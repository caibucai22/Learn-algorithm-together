package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Csy
 * @Classname 编辑距离
 * @date 2022-03-19 14:52
 * @Description TODO
 */
public class 编辑距离 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 15, M = 1010;

    public static void main(String[] args) throws Exception {
        String[] nums1 = in.readLine().split(" ");
        int n = Integer.parseInt(nums1[0]), m = Integer.parseInt(nums1[1]);

        String[] strs = new String[M];
        for (int i = 0; i < n; i++) {
            strs[i] = in.readLine();
        }

        while (m-- > 0) {
            String[] d = in.readLine().split(" ");
            String strB = d[0];
            int limit = Integer.parseInt(d[1]);

            // 计算str 与每个 strs中的 字符串的编辑距离 然后与 limit 比较
            int cnt = 0;
            // 统计符合条件的字符串数
            for (int i = 0; i < n; i++) {

//                strA strB
                if (minEdit(strs[i], strB) <= limit) cnt++;
            }
            out.write(cnt + "\n");
        }

        in.close();
        out.flush();
        out.close();
    }

    public static int minEdit(String strA, String strB) {
        int[][] f = new int[N][N];

        int lenA = strA.length();
        int lenB = strB.length();
        for (int i = 0; i <= lenA; i++) f[i][0] = i;
        for (int j = 0; j <= lenB; j++) f[0][j] = j;


        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                if (strA.charAt(i - 1) == strB.charAt(j - 1)) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                } else {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }

        return f[lenA][lenB];
    }

}
