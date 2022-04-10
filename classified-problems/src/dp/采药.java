package dp;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 采药
 * @date 2022-03-07 16:06
 * @Description https://www.acwing.com/problem/content/425/
 */
public class 采药 {

    static final int N = 1010;

    public static void main(String[] args) {
        // 分析数据规模 1-1000 1-100

        // 动态规划
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(), M = sc.nextInt();

        int[] dp = new int[N];
        // dp[i] 表示时间i 所能得到的最大草药价值

        // 采药时间是物品体积，草药价值是物品价值
        for(int i=0;i<M;i++){
            int w = sc.nextInt(),v = sc.nextInt();

            for(int j=T; j>= w;j--){
                dp[j] = Math.max(dp[j],dp[j-w]+v);
            }
        }
        System.out.println(dp[T]);

    }
}
