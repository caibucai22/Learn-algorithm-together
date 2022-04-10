package competition.sheng._2021;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname 路径
 * @date 2022-04-07 13:48
 * @Description TODO
 */
public class 路径 {
    static final int N = 2030, INF = 0x3f3f3f3f;

    static int[][] g = new int[N][N];
    static int[] d = new int[N];
    static boolean[] st = new boolean[N];

    static int n = 2021;

    public static void main(String[] args) {

        for (int i = 1; i <= 2021; i++) {
            for (int j = 1; j <= 2021; j++) {
                g[i][j] = INF;
                int abs = Math.abs(i - j);
                if(abs <=21)g[i][j] = lcm(i,j);
                if(i==j)g[i][j] = 0;
            }

        }

        dijkstra();

        System.out.println(d[n]);
    }

    private static void dijkstra() {

        Arrays.fill(d,INF);
        d[1] = 0;

        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || d[t] > d[j])) {
                    t = j;
                }
            }
            if (t == n) break;
            st[t] = true;

            for (int j = 1; j <= n; j++) {
                d[j] = Math.min(d[j], d[t] + g[t][j]);
//                if (d[j] > d[t] + g[t][j]) {
//                    d[j] = d[t] + g[t][j];
//                }
            }


        }

    }


    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }


    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


}
