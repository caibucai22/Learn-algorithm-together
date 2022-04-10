package preSum;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname Acwing795
 * @date 2022-03-09 13:38
 * @Description TODO
 */
public class Acwing795 {

    static final int N = 100010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        int[] nums = new int[N];
        int[] preSum = new int[N];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
            preSum[i] = preSum[i - 1] + nums[i];
        }

        while (m-- > 0) {
            int l = sc.nextInt(), r = sc.nextInt();
            System.out.println(preSum[r] - preSum[l - 1]);
        }
    }
}
