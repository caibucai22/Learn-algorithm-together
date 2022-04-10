package 最短路系列;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Csy
 * @Classname spfa判断负环
 * @date 2022-04-07 9:04
 * @Description TODO
 */
public class spfa判断负环 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N = 100010, INF = (int) 1e9;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] w = new int[N];
    static int[] nx = new int[N];
    static int idx;

    static int n, m;
    static int[] d = new int[N];
    static int[] cnt = new int[N]; // 记录 到达i点经过的点数
    static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().trim().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        // init
        Arrays.fill(h, -1);

        // construct
        for (int i = 0; i < m; i++) {
            s = in.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);

            add(a, b, w);
        }

        boolean spfa = spfa();
        if (spfa) System.out.println("Yes");
        else System.out.println("No");

    }

    private static boolean spfa() {
        Arrays.fill(d, INF);

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            q.offerLast(i);
            st[i] = true;
        }

        while (!q.isEmpty()) {
            int t = q.peekFirst();
            q.pollFirst();

            st[t] = false;

            for (int i = h[t]; i != -1; i = nx[i]) {
                int j = e[i];
                if (d[j] > d[t] + w[i]) {
                    d[j] = d[t] + w[i];
                    cnt[j] = cnt[t] + 1; // 细节
                    if (cnt[j] >= n) return true;
                    if (!st[j]) {
                        q.offerLast(j);
                        st[j] = true;
                    }
                }
            }
        }
        return false;
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        nx[idx] = h[a];
        h[a] = idx++;
    }
}
