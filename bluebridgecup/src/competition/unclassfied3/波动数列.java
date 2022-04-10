package competition.unclassfied3;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 波动数列
 * @date 2022-04-01 12:33
 * @Description TODO
 */
public class 波动数列 {

    static final int N = 1010;
    static final int MOD = 100000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();

        int[][] f = new int[N][N];
        /**
         * f[i][j] 表示前i项%n=j 的方案数
         * (sum(i-1)+i*a) %n = j
         *  sum(i-1) % n = (j-i*a) % n
         */

        f[0][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = (f[i - 1][getMod(j - (n - i) * a, n)] + f[i - 1][getMod(j + (n-i) * b, n)]) % MOD;
            }
        }

        System.out.println(f[n - 1][getMod(s,n)]);
    }

    public static int getMod(int a, int mod) {
        return ((a % mod) + mod) % mod;
    }

}
