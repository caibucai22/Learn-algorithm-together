package dp;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 整数划分
 * @date 2022-03-19 16:10
 * @Description TODO 可以转化为 完全背包问题
 */
public class 整数划分 {

    static final int N = 1010;
    static final int MOD = (int) (1e9+7);

    public static void main(String[] args) {
        /**
         * 状态表示
         * 集合: f[i,j] 从1到i，总体积恰好为j的方式
         *
         * 属性：数量
         *
         * 状态计算（集合的划分）
         */
        Scanner sc = new Scanner(System.in);
        int[] f = new int[N];
        int n = sc.nextInt();
        f[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                f[j] = (f[j]+f[j-i]) % MOD;
            }
        }

        System.out.println(f[n]);

    }

}
