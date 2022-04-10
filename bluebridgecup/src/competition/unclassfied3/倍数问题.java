package competition.unclassfied3;

import java.io.*;

/**
 * @author Csy
 * @Classname 倍数问题
 * @date 2022-04-07 16:25
 * @Description TODO 动态规划
 */
public class 倍数问题 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100010;

    static int n, K;

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        s = in.readLine().split(" ");
        int[] w = new int[N];
        for (int i = 1; i <= n; i++) w[i] = Integer.parseInt(s[i - 1]);

        // f[i][j][k] 前i个数 取了j个 余数为k

        int[][][] f = new int[n+1][4][K];
        for(int i=0;i<K;i++){
            f[0][0][i] = Integer.MIN_VALUE;
        }
        f[0][0][0] = 0;

        for (int i = 1; i <= n; i++) { // 物品
            for (int j = 1; j <= 3; j++) { // 容量
                for (int k = 0; k < K; k++) { // 余数
                    f[i][j][k] = Math.max(f[i-1][j][k],f[i-1][j-1][((k-w[i])%K + K)%K]+w[i]);
                }
            }
        }

        System.out.println(f[n][3][0]);

    }

}
