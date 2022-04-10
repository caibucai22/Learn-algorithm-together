package competition.unclassfied3;

import java.io.*;
import java.util.Arrays;

/**
 * @author Csy
 * @Classname 递增三元组
 * @date 2022-04-07 18:39
 * @Description TODO 1.二分 2.双指针 3.前缀和
 */
public class 递增三元组 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(s[i]);
        }
        s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        long ret = 0;
        for (int i = 0; i < n; i++) {
            int alen = 0, blen = 0;
            int t = b[i];
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + (r - l + 1 >> 1);
                // 找a中最后一个小于t的
                if (a[mid] < t) l = mid;
                else r = mid-1;
            }
            if (a[l] < t) alen = l + 1;

            l = 0;
            r = n - 1;
            while (l < r) {
                int mid = l + (r - l >> 1);
                // 找第一大于t的数
                if (c[mid] >t) r = mid;
                else l = mid + 1;
            }
            // 1 2 3 4 5
            if (c[l] > t) blen = n - l;

            ret += (long)alen * blen; // 会爆int
        }
        System.out.println(ret);
    }

}
