package competition.unclassfied;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname 四平方和
 * @date 2022-03-24 13:30
 * @Description TODO
 */
public class 四平方和 {

    static int[] a;
    static int N;
    static int cnt;
    public static void main(String[] args) {
        cnt = 0;
        a = new int[4];
        Arrays.fill(a,-1);
        N = 773535;
        dfs(0);
    }


    private static void dfs(int start){
        if(start == 4){
            check(a);
            if(cnt == 1)System.exit(0);
            return;
        }
        for(int i=0;i<= (int) Math.sqrt(N);i++){
            // 这里 i<= 根号N,      如果不写表示无穷的话会在第一个数那里陷入无穷个状态
            if(start > 0 && a[start-1] > i)continue;
            // 这个剪枝 是保证是一个非减序列 ，效果还不错



            a[start] = i;
            dfs(start+1);
            a[start] = -1;
        }
    }

    private static void check(int[] a){
        if(a[0]*a[0]+a[1]*a[1]+a[2]*a[2]+a[3]*a[3] == N ){
            cnt++;
            Arrays.stream(a).forEach(o -> System.out.printf("%d ",o));
            System.out.println();
        }
    }

}
