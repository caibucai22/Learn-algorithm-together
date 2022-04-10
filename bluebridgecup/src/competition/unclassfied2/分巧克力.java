package competition.unclassfied2;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 分巧克力
 * @date 2022-03-28 14:54
 * @Description TODO
 */
public class 分巧克力 {

    static int[] h;
    static int[] w;
    static int n,k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        h = new int[n];
        w = new int[n];

        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        int l = 0, r = (int) 1e5;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (check(mid)) l = mid;
            else {
                r = mid - 1;
            }
        }
        System.out.println(r);
    }

    private static boolean check(int len) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += (h[i] / len) * (w[i] / len);
            if (num >= k) return true;
        }
        return false;
    }

}
