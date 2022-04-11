package _week._47;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 牛奶桶
 * @date 2022-04-10 22:27
 * @Description TODO 背包问题 完全背包
 */
public class 牛奶桶 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] w = new int[2];
        w[0] = sc.nextInt();
        w[1] = sc.nextInt();
        int m = sc.nextInt();
        int[] f = new int[m + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = w[i]; j <= m; j++) {
                f[j] = Math.max(f[j], f[j - w[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
