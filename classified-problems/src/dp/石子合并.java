package dp;

import java.io.*;

/**
 * @author Csy
 * @Classname 石子合并
 * @date 2022-03-19 15:32
 * @Description TODO    区间dp 一般先枚举区间长度 再枚举左右断点
 */
public class 石子合并 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 310;

    public static void main(String[] args) throws IOException {

        /**
         * dp 分析
         * 状态表示
         * 集合：[i,j]段合并的方式的集合
         * 属性：所有合并方式中最小的代价
         *
         *
         * 状态计算
         * f[i][j] = f[i][k] + f[k+1][j] k 2~j-1
         */

        int n = Integer.parseInt(in.readLine());

        int[] preSum = new int[N];
        int[][] f = new int[N][N];

        for (int i = 1; i <= n; i++) {
            preSum[i] = Integer.parseInt(in.readLine());
            preSum[i] += preSum[i - 1];
        }

        // 先枚举区间长度 再枚举左右端点
        for (int len = 2; len <= n; len++) {
            for(int i=1;i+len-1<=n;i++){
                int l = i,r = i+len-1;
                f[l][r] = (int) 1e8;
                for(int k = l;k<r;k++){
                    f[l][r] = Math.min(f[l][r],f[l][k]+f[k+1][r]+(preSum[r]-preSum[l-1]));
                }
            }
        }

        out.write(f[1][n]+"\n");

        in.close();
        out.flush();
        out.close();
    }

}
