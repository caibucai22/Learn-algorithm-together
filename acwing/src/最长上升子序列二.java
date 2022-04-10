import java.io.*;

/**
 * @author Csy
 * @Classname 最长上升子序列二
 * @date 2022-04-05 18:19
 * @Description TODO 数据范围 10的5次方 下标从 1开始
 */
public class 最长上升子序列二 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 1000010;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine().split(" ")[0]);
        int[] a = new int[N];
        String[] s = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) a[i] = Integer.parseInt(s[i-1]);

        int[] q = new int[N];
        q[0] = Integer.MIN_VALUE;
        int len = 0;
        for (int i = 1; i <= n; i++) {
            int l = 0, r = len;
            while (l < r) {
                //找到小于a[i]的最大的数 （不是找最后一个等于a[i]的数）
                int mid = l + (r - l + 1 >> 1);
                if (q[mid] < a[i]) l = mid;
                else {
                    r = mid - 1;
                }
            }
            len = Math.max(len,l+1);
            // 把数更新到 l+1长度 最小的数
            q[l+1] = a[i];
        }
        out.write(len);

        in.close();
        out.flush();
        out.close();
    }
}
