package competition.unclassfied3;

import java.io.*;

/**
 * @author Csy
 * @Classname 合根植物
 * @date 2022-04-08 13:29
 * @Description TODO
 */
public class 合根植物 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100010;
    static int[] p = new int[N];

    static int n, m;

    public static void main(String[] args) throws IOException {

        String[] s = in.readLine().trim().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);

        for (int i = 1; i <= m * n; i++) p[i] = i;

        s = in.readLine().trim().split(" ");
        int k = Integer.parseInt(s[0]);


        for (int i = 0; i < k; i++) {
            s = in.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
            a = find(a);
            b = find(b);
            if (a != b) p[a] = b;
        }

        int ret = 0;
        int[] a = new int[N];
        for (int i = 1; i <= m * n; i++) {
            a[find(i)] = 1; // 找到每个连通的根赋值为1
        }
        for (int i = 1; i <= m * n; i++) {
            if(a[i] > 0)ret++;
        }

        System.out.println(ret);
    }

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

}
