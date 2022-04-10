package 最短路系列;

import java.io.*;
import java.util.Arrays;

/**
 * @author Csy
 * @Classname Dijkstra求最短路
 * @date 2022-04-07 10:00
 * @Description TODO
 */
public class Dijkstra求最短路 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 510, M = 100010, INF = (int) 1e9;


    static int n, m;
    static int[][] g = new int[N][N];
    static int[] d = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().trim().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);


        // init
        Arrays.stream(g).forEach(o -> Arrays.fill(o,INF));

        for (int i = 0; i < m; i++) {
            s = in.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);

            g[a][b] = Math.min(g[a][b], w);
        }

        dijkstra();

        if (d[n] > INF / 2) System.out.println(-1);
        else System.out.println(d[n]);

    }

    private static void dijkstra() {
        Arrays.fill(d, INF);
        d[1] = 0;

        for (int i = 0; i < n-1; i++) {
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
            }
        }

    }


}
