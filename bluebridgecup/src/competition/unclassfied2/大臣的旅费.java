package competition.unclassfied2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Csy
 * @Classname 大臣的旅费
 * @date 2022-03-30 19:14
 * @Description TODO 两段 树的直径问题
 */
public class 大臣的旅费 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<int[]> list[];
    static int[] dis;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        list = new ArrayList[n+1];
        dis = new int[n+1];
//        Arrays.fill(list,new ArrayList<>());
        for(int i=0;i<n-1;i++){

            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            // 初始化
            if(list[a] == null)list[a] = new ArrayList<>();
            if(list[b] == null)list[b] = new ArrayList<>();

            list[a].add(new int[]{b,w});
            list[b].add(new int[]{a,w});
         }

        // 第一段
        dfs(1,-1,0);

        int idx = 1;
        for(int i=1;i<=n;i++){ // 细节 i从1开始，到n
            if(dis[i] > dis[idx]){
                idx = i;
            }
        }

        // 第二段
        dfs(idx,-1,0);

        for(int i=1;i<=n;i++){
            if (dis[i] > dis[idx]){
                idx = i;
            }
        }

        int s = dis[idx];
        long ret = s*10 + (long)s*(s+1)/2;
        System.out.println(ret);

        in.close();
        out.flush();
        out.close();
    }

    private static void dfs(int start,int father,int d){
        dis[start] = d;
        for(int[] node : list[start]){
            if(node[0] != father){
                dfs(node[0],start,node[1]+d);
            }
        }
    }


}
class edge{
    int id;
    int w;

    public edge(int id,int w){
        this.id = id;
        this.w = w;
    }
}
