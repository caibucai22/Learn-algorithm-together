package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Csy
 * @Classname 最长公共子序列
 * @date 2022-03-19 11:00
 * @Description Acwing 897
 *
 * 状态表示
 * 集合：所有A[1-i] 和 B[1-i] 的公共子序列的集合
 * 属性：长度最大值max
 *
 * 状态计算
 * 集合分类 00 01 10 11
 * 00 不包含a[i] b[j]
 * 10 包含a[i] 不包含b[j]
 * 01 不包含a[i] 包含b[j]
 * 11 包含a[i] 包含b[j]
 *
 * 且 00 这种状态被其他状态所包含 无需再考虑，只需要考虑 10 01 11 三种
 */
public class 最长公共子序列 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 1010;

    public static void main(String[] args)throws Exception {
        String[] nums = in.readLine().split(" ");
        int n = Integer.parseInt(nums[0]),m = Integer.parseInt(nums[1]);

        String a = in.readLine();
        String b = in.readLine();

        int[][] f = new int[N][N];

        f[0][0] = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                f[i][j] = Math.max(f[i-1][j],f[i][j-1]);
                if(a.charAt(i-1) == b.charAt(j-1)){
                    f[i][j] = Math.max(f[i][j],f[i-1][j-1]+1);
                }
            }
        }
        out.write(f[n][m]+"\n");

        in.close();
        out.flush();
        out.close();
    }

}
