package competition.sheng._2021;

import java.io.*;

/**
 * @author Csy
 * @Classname 网络分析_带权并查集
 * @date 2022-04-08 14:35
 * @Description TODO
 */
public class 网络分析_带权并查集 {


    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 10010;
    static int[] p = new int[N];
    static int[] w = new int[N];
    static int n, m;

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().trim().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        for (int i = 1; i <= n; i++) p[i] = i;

        for (int i = 0; i < m; i++) {
            s = in.readLine().trim().split(" ");
            int op = Integer.parseInt(s[0]);
            int a = Integer.parseInt(s[1]), b = Integer.parseInt(s[2]);
            if (op == 1) {
                a = find(a);
                b = find(b);
                if (a != b) {
                    p[a] = b;
                    w[a] -= w[b];
                }
            } else if (op == 2) {
                a = find(a);
                w[a] += b;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (i != find(i)) w[i] += w[find(i)];
            System.out.printf("%d ", w[i]);
        }

    }

    private static int find(int x) {
        if (p[x] == x || p[p[x]] == p[x]) return p[x];
        int root = find(p[x]);
        w[x] += w[p[x]];
        p[x] = root;
        return root;
    }

}
