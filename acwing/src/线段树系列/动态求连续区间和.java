package 线段树系列;

import java.io.*;

/**
 * @author Csy
 * @Classname 动态求连续区间和
 * @date 2022-04-05 19:31
 * @Description TODO
 */
public class 动态求连续区间和 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static class node {
        int l;
        int r;
        int sum;
    }

    static final int N = 100010;
    static node[] tree = new node[4 * N];
    static int[] w = new int[N];

    static void pushUp(int cur) {
        tree[cur].sum = tree[cur << 1].sum + tree[cur << 1 | 1].sum;
    }

    static void build(int cur, int l, int r) {
        tree[cur] = new node();
        tree[cur].l = l;
        tree[cur].r = r;
        if (l == r) {
            tree[cur].sum = w[l];
        } else {
            int mid = l + r >> 1;
            build(cur << 1, l, mid);
            build(cur << 1 | 1, mid + 1, r);
            pushUp(cur);
        }
    }

    static int query(int cur, int l, int r) {
        if (l <= tree[cur].l && r >= tree[cur].r) return tree[cur].sum;

        int mid = tree[cur].l + tree[cur].r >> 1;
        int sum = 0;
        if (mid >= l) sum += query(cur << 1, l, r);
        if (r >= mid + 1) sum += query(cur << 1 | 1, l, r);

        return sum;
    }

    // 修改值
    static void modify(int cur, int idx, int v) {
        if (tree[cur].l == tree[cur].r) {
            tree[cur].sum += v;
        } else {
            int mid = tree[cur].l + tree[cur].r >> 1;
            if (idx <= mid) modify(cur << 1, idx, v);
            else {
                modify(cur << 1 | 1, idx, v);
            }
            pushUp(cur);
        }
    }

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        s = in.readLine().trim().split(" ");
        for (int i = 1; i <= n; i++) w[i] = Integer.parseInt(s[i - 1]);
        build(1, 1, n);

        while (m-- > 0) {
            s = in.readLine().trim().split(" ");
            int k = Integer.parseInt(s[0]);
            if (k == 0) {
                int l = Integer.parseInt(s[1]);
                int r = Integer.parseInt(s[2]);
                int ret = query(1, l, r);
                out.write(ret + "\n");
            } else if (k == 1) {
                int idx = Integer.parseInt(s[1]);
                int v = Integer.parseInt(s[2]);
                modify(1, idx, v);
            }
        }
        in.close();
        out.flush();
        out.close();
    }

}

