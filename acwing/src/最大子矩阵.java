import java.io.*;

/**
 * @author Csy
 * @Classname 最大子矩阵
 * @date 2022-04-02 19:59
 * @Description TODO
 */
public class 最大子矩阵 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = 2010;

    public static void main(String[] args) throws IOException {
        String s[] = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] a = new int[n];
        int[] b = new int[m];

        String[] as = in.readLine().split(" ");
        String[] bs = in.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(as[i]);
        }
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(bs[i]);
        }

        // 前缀和 用来算 区间和
        int[] s1 = new int[N];
        int[] s2 = new int[N];

        for (int i = 1; i <= n; i++) {
            s1[i] = s1[i - 1] + a[i - 1];
        }
        for (int i = 1; i <= m; i++) {
            s2[i] = s2[i - 1] + b[i - 1];
        }

        // 存放每一个区间长度对应的最小值
        int[] alen = new int[N];
        int[] blen = new int[N];
        // 找到一个矩形长 长度对应区间和的最小值
        for (int len = 1; len <= n; len++) {
            alen[len] = Integer.MAX_VALUE;
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                alen[len] = Math.min(alen[len], s1[j] - s1[i - 1]);
            }
        }

        // 找到一个矩形宽 长度对应区间和的最小值
        for (int len = 1; len <= m; len++) {
            blen[len] = Integer.MAX_VALUE;
            for (int i = 1; i + len - 1 <= m; i++) {
                int j = i + len - 1;
                blen[len] = Math.min(blen[len], s2[j] - s2[i - 1]);
            }
        }

        // alen[] blen[] 是长度为i区间和的最小值 具有单调性

        int x = Integer.parseInt(in.readLine().split(" ")[0]);
        int ret = 0;

        // 双指针
        // 这里的i j 都是指长宽
        for (int i = 1, j = m; i <= n; i++) {
            while (j > 0 && blen[j] > x / alen[i]) j--;
            ret = Math.max(ret, i * j);
        }

        System.out.println(ret);

        in.close();
        out.flush();
        out.close();
    }

}
