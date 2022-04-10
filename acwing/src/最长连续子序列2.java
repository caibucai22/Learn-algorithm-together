import java.io.*;

/**
 * @author Csy
 * @Classname 最长连续子序列2
 * @date 2022-04-02 20:27
 * @Description TODO 优化代码结构版
 */
public class 最长连续子序列2 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100010;

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        String[] num = in.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(num[i]);
        }

        int l = 0, r = 0;
        int[] hash = new int[N];

        int len = 0;
        for (int i = 0, j = 0, type = 0; i < n; i++) {

            if (hash[a[i]] == 0) type++;
            hash[a[i]]++;

            while (type > k) {
                if (hash[a[j]] == 1) type--;
                hash[a[j]]--;
                j++;
            }

            if (i - j + 1 > len) {
                len = i - j + 1;
                l = j;
                r = i;
            }
        }
        l++;
        r++;
        System.out.println(l + " " + r);
    }

}
