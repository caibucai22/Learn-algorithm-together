package dp;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 分组背包
 * @date 2022-03-17 13:28
 * @Description TODO
 */
public class 分组背包 {

    static final int N = 110;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), v = sc.nextInt();
        // 存体积
        int[][] V = new int[N][N];
        // 存价值
        int[][] W = new int[N][N];
        // 存每组物品个数
        int[] S = new int[N];

        int[][] f = new int[N][N]; // 二维
        int[] f2 = new int[N]; // 一维

        for (int i = 1; i <= n; i++) {
            S[i] = sc.nextInt();
            for (int j = 0; j < S[i]; j++) {
                V[i][j] = sc.nextInt();
                W[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = v; j >= 0; j--) {
                int tmpMax = 0;
                for (int k = 0; k < S[i]; k++) {
                    if (V[i][k] <= j) {
                        // 这样写是有问题的 f[i-1][j]是定值，这样更新得到选取的是最后一个大于不选情况的物品
                        // 而不一定是该组里面具有最大价值的物品

//                        f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - V[i][k]] + W[i][k]);
//                        tmpMax = tmpMax > f[i][j] ? tmpMax : f[i][j];

                        // 空间优化

                        f2[j] = Math.max(f2[j],f2[j-V[i][k]]+W[i][k]);
                        tmpMax = tmpMax > f2[j] ? tmpMax : f2[j];

                    } else {
                        // 空间不够就是不选
//                        f[i][j] = f[i - 1][j];

                        f2[j] = f2[j];
                    }
                }
                // 更新最大价值
//                f[i][j] = tmpMax > f[i][j] ? tmpMax : f[i][j];

                f2[j] = tmpMax > f2[j] ? tmpMax : f2[j];
            }
        }

//        System.out.println(f[n][v]);
        System.out.println(f2[v]);
    }
}
