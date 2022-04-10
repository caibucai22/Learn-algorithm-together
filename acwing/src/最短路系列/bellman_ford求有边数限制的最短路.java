package 最短路系列;

import java.io.*;
import java.util.Arrays;

/**
 * @author Csy
 * @Classname bellman_ford求有边数限制的最短路
 * @date 2022-04-07 9:31
 * @Description TODO
 */
public class bellman_ford求有边数限制的最短路 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 510, M = 10010, INF = 0x3f;
    static int[] d = new int[N];
    static int[] backup = new int[N];


    static class Edge {
        int a;
        int b;
        int w;
    }

    static Edge[] edges = new Edge[M];


    static int n, m, k;

    public static void main(String[] args) throws IOException {

        String[] s = in.readLine().trim().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        for (int i = 1; i <= m; i++) {
            s = in.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            edges[i] = new Edge();
            edges[i].a = a;
            edges[i].b = b;
            edges[i].w = w;
        }

        bellmanFord();

        if (d[n] > INF / 2) System.out.println("impossible");
        else System.out.println(d[n]);
    }

    private static void bellmanFord() {

        // init
        Arrays.fill(d, INF);
        d[1] = 0;

        for (int i = 0; i < k; i++) {
            System.arraycopy(d, 0, backup, 0, N);

            for (int j = 1; j <= m; j++) {
                Edge t = edges[j];
                int a = t.a, b = t.b, w = t.w;
                d[b] = Math.min(d[b], backup[a] + w);
            }
        }
    }

}
