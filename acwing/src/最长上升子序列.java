import java.util.Scanner;

/**
 * @author Csy
 * @Classname 最长上升子序列
 * @date 2022-03-31 10:03
 * @Description TODO
 */
public class 最长上升子序列 {

    static final int N = 1010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[N];
        int[] f = new int[N];
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        // f[i] 表示从0到i的递增子序列长度
        // f[i] 表示以a[i] 结尾的递增子序列长度
        for (int i = 1; i <= n; i++) {
            f[i] = 1;
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        // 为什么要遍历呢？而不是f[n]
        // 1,2,3,4,5,1 此时f[n] = 1,最长是以a[5]结尾的递增子序列
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            ret = Math.max(ret, f[i]);
        }

        System.out.println(ret);
    }

}
