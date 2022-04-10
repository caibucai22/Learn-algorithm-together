package dp;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 滑雪
 * @date 2022-03-19 16:59
 * @Description TODO ACWing 901
 */
public class 滑雪 {

    static final int N = 310;
    static int n, m;
    static int[][] g = new int[N][N];
    static int[][] f = new int[N][N];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                g[i][j] = sc.nextInt();
                f[i][j] = -1;
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                res = Math.max(res, dp(i, j));
            }
        }

        System.out.println(res);

    }


    public static int dp(int x, int y) {
        if (f[x][y] != -1) return f[x][y];

        f[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 1 && a <= n && b >= 1 && b <= m && g[a][b] < g[x][y]) {
                f[x][y] = Math.max(f[x][y], dp(a, b) + 1);
            }
        }

        return f[x][y];
    }

}
