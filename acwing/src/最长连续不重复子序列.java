import java.io.*;

/**
 * @author Csy
 * @Classname 最长连续不重复子序列
 * @date 2022-04-02 20:50
 * @Description TODO
 */
public class 最长连续不重复子序列 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100010;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine().split(" ")[0]);

        String[] s = in.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        int[] hash = new int[N];
        int len = 0;
        for (int l = 0, r = 0, t = 0; r < n; r++) {
//            自己写的垃圾代码 acwing 也可以AC
//            if (hash[a[r]] == 0) t++;
//            hash[a[r]]++;
//
//            // 存在重复元素就移动窗口
//            while (t > 0 && r - l + 1 != t) { // 这个判断条件就很玄学
//                if (hash[a[l]] == 1) t--;
//                hash[a[l]]--;
//                l++;
//            }
//            // 1 2 2 3 5
//            // 不含重复元素 并更新
//            if (r - l + 1 == t) {
//                len = Math.max(len, r - l + 1);
//            }


//            yxc的代码
            // yxc
            hash[a[r]]++;
            // 维持序列无重复 重复只可能发生在hash[a[r]]那里
            while (l < r && hash[a[r]] > 1) {
                hash[a[l]]--;
                l++;
            }
            // 更新
            len = Math.max(len, r - l + 1);
        }
        System.out.println(len);

    }

}
