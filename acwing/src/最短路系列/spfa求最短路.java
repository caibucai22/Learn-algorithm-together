package 最短路系列;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Csy
 * @Classname spfa求最短路
 * @date 2022-04-07 8:42
 * @Description TODO
 */
public class spfa求最短路 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100010, INF = 0x3f3f3f3f;
    static int[] h = new int[N];
    static int[] w = new int[N];
    static int[] e = new int[N];
    static int[] nx = new int[N];
    static int idx;

    static int n, m;
    static int[] d = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        // init
        Arrays.fill(h, -1);

        // construct
        for (int i = 0; i < m; i++) {
            s = in.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]), w = Integer.parseInt(s[2]);
            add(a, b, w);
        }

        //
        spfa();

        int t = d[n];
        if(t > INF/2) System.out.println("impossible");
        else System.out.println(t);

    }

    private static void spfa() {
        Arrays.fill(d, INF);
        d[1] = 0;

        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(1);

        st[1] = true;

        while (!q.isEmpty()) {
            int t = q.peekFirst();
            q.pollFirst();

            st[t] = false;

            for (int i = h[t]; i != -1; i = nx[i]) {
                int j = e[i];
                if (d[j] > d[t] + w[i]) {
                    d[j] = d[t] + w[i];
                    if (!st[j]) {
                        q.offerLast(j);
                        st[j] = true;
                    }
                }
            }

        }

    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        nx[idx] = h[a];
        h[a] = idx++;
    }

}
