package 线段树系列;

import java.io.*;
import java.util.Arrays;

/**
 * @author Csy
 * @Classname 数列区间最大值
 * @date 2022-04-05 19:01
 * @Description TODO
 */
public class 数列区间最大值 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static class node {
        int l;
        int r;
        int max;

        public node() {
        }

        public node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public node(int l, int r, int max) {
            this.l = l;
            this.r = r;
            this.max = max;
        }
    }

    static final int N = 100010;
    static node[] tree = new node[N * 4];
    static int[] w = new int[N];

    public static void pushUp(int cur) {
        tree[cur].max = Math.max(tree[cur << 1].max, tree[cur << 1 | 1].max);
    }

    public static void build(int cur, int l, int r) {
        // 先初始化
        tree[cur] = new node();
        tree[cur].l = l;
        tree[cur].r = r;
        if (l == r) tree[cur].max = w[l];
        else {
            int mid = l + r >> 1;
            build(cur << 1, l, mid);
            build(cur << 1 | 1, mid + 1, r);
            pushUp(cur);
        }
    }

    public static int query(int cur, int l, int r) {
        if (l <= tree[cur].l && r >= tree[cur].r) return tree[cur].max;

        int mid = tree[cur].l + tree[cur].r >> 1;
        int max = Integer.MIN_VALUE; // 赋最小值
        if (mid >= l) max = Math.max(max, query(cur << 1, l, r));
        if (r >= mid + 1) max = Math.max(max, query(cur << 1 | 1, l, r));

        return max;
    }


    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[] a = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) w[i] = Integer.parseInt(a[i - 1]);
        Arrays.fill(tree, new node());
        build(1, 1, n);
        while (m-- > 0) {
            String[] b = in.readLine().split(" ");
            int l = Integer.parseInt(b[0]);
            int r = Integer.parseInt(b[1]);

            int q = query(1, l, r);
            out.write(q + "\n");
        }

        in.close();
        out.flush();
        out.close();
    }

}


