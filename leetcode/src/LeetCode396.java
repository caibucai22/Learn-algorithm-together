import java.util.Arrays;

/**
 * @author Csy
 * @Classname LeetCode396
 * @date 2022-04-22 23:38
 * @Description TODO
 */
public class LeetCode396 {

    public static void main(String[] args) {
        int[] test = {4, 3, 2, 6};
        Solution396 s = new Solution396();
        int i = s.maxRotateFunction(test);
        System.out.println(i);
    }
}

class Solution396 {

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int sum = 0;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f[0] += i * nums[i];
        }
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + sum - n * nums[n - i];
        }
        return Arrays.stream(f).max().getAsInt();
    }
}
