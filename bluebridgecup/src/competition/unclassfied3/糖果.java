package competition.unclassfied3;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 糖果
 * @date 2022-04-07 16:44
 * @Description TODO
 */
public class 糖果 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] w = new int[n+1];
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }


        int[][] f = new int[n + 1][k];

        for(int i=0;i<k;i++)f[0][i] = Integer.MIN_VALUE;

        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                f[i][j] = Math.max(f[i-1][j],f[i-1][((j-w[i])%k+k)%k]+w[i]);
            }
        }

        System.out.println(f[n][0]);
    }

}
