package day01;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname Solution_1255_dp
 * @date 2022-01-19 16:43
 * @Description TODO 区间dp
 */
public class Solution_1255_dp {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] energy = new int[202];
        int[][] dp = new int[202][202];

        for (int i = 1; i <= N; i++) {
            energy[i] = s.nextInt();
            energy[i + N] = energy[i];
        }

        // 三层循环

        for (int len = 2; len <= N; len++) {

            for (int i = 1; i + len -1< 2 * N; i++) {

                int j = i + len-1;

                for (int k = i; k < j; k++) {

                    // dp[i][j] 表示 从i开始到j的最大能量
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j] + energy[i] * energy[k + 1]*energy[j+1]);
                }
            }
        }


        int ret = 0;
        for (int i = 1; i <= N; i++) {
            ret = Math.max(ret, dp[i][i + N-1]);
        }

        System.out.println(ret);


    }
}
