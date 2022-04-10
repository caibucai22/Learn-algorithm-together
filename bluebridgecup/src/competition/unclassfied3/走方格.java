package competition.unclassfied3;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 走方格
 * @date 2022-04-07 20:09
 * @Description TODO
 */
public class 走方格 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] f = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) f[i][1] = 1;
        for (int i = 1; i <= m; i++) f[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i % 2 == 0 && j % 2 == 0) continue;
                f[i][j] = f[i][j - 1] + f[i - 1][j];
            }
        }
        System.out.println(f[n][m]);

    }

}
