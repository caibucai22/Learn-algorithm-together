package 最短路系列;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * @author Csy
 * @Classname 堆优化Dijkstra求最短路
 * @date 2022-04-07 10:08
 * @Description TODO
 */
public class 堆优化Dijkstra求最短路 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 510, M = 100010, INF = (int) 1e9;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] w = new int[M];
    static int[] nx = new int[M];
    static int idx;

    static int n, m;
    static int[] d = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().trim().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            s = in.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);

            add(a, b, w);
        }

        dijkstra();

        if (d[n] > INF / 2) System.out.println(-1);
        else System.out.println(d[n]);

    }

    private static void dijkstra() {
        Arrays.fill(d, INF);
        d[1] = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        heap.offer(new int[]{1, 0}); //点 距离

        while (!heap.isEmpty()) {
            int[] a = heap.peek();
            heap.poll();

            int t = a[0], distance = a[1];
            if (st[t]) continue;
            st[t] = true;

            for (int i = h[t]; i != -1; i = nx[i]) {
                int j = e[i];
                if (d[j] > distance + w[i]) {
                    d[j] = distance + w[i];
                    heap.offer(new int[]{j, d[j]});
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
