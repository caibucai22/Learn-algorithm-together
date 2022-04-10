package competition.unclassfied2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Csy
 * @Classname 完全二叉树的权值
 * @date 2022-03-30 18:02
 * @Description  蓝桥杯官网过了 acwing没过
 */
public class 完全二叉树的权值 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static long ret;
    static int depth;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(in.readLine().split(" ")[0]);
        int[] a = new int[n];
        String[] s = in.readLine().split(" ");
        for(int i=0;i<n;i++)a[i] = Integer.parseInt(s[i]);

        bfs(a);

        System.out.println(depth);
    }

    private static void bfs(int[] num){
        int n = num.length;
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{0,num[0]});
        int d = 0;
        while(!q.isEmpty()){
            int size = q.size();
            d++;
            long layer = 0;
            for(int i=0;i<size;i++){
                int[] t = q.pollFirst();
                layer += t[1];
                int left = 2*t[0]+1,right = 2*t[0]+2;
                if(left < n ){
                    q.offer(new int[]{left,num[left]});
                }
                if( right < n){
                    q.offer(new int[]{right,num[right]});
                }

            }
            if(layer > ret){
                ret = layer;
                depth = d;
            }
        }
    }

}
