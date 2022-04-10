package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Csy
 * @Classname 最长上升子序列
 * @date 2022-03-19 9:51
 * @Description Acwing 895
 */
public class 最长上升子序列 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 1010;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(in.readLine());

        int[] a = new int[N];
        String[] nums = in.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(nums[i - 1]);
        }

        int[] f = new int[N];
        // f[i] 表示以 a[i] 结尾的最长上升子序列长度
//        f[1] = 1;
        for (int i = 1; i <= n; i++) {

            f[i] = 1;
            // 这个初始化 很重要 容易忽略 ，可能只初始化一个f[1] = 1

            for (int j = 1; j < i; j++) {
                if(a[j] < a[i])f[i] = Math.max(f[i],f[j]+1);
            }
        }

        int res = 0;
        for(int i=1;i<=n;i++){
            res = res < f[i] ? f[i] :res;
        }

       out.write(res+"\n");
        in.close();
        out.flush();
        out.close();
    }
}
