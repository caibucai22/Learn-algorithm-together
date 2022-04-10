import java.util.Arrays;

/**
 * @author Csy
 * @Classname LeetCode1005
 * @date 2021-12-03 20:37
 * @Description TODO
 */
public class LeetCode1005 {

    public static int largestSumAfterKNegations(int[] nums, int k) {
        // 分偶数次还是奇数次

        // 偶数次，把所有的负数变为正数，找到一个最小的数后，一直翻转，最终可能为负数或者正数

        // 先把数组按从小到大排序
        Arrays.sort(nums);
        int minus = 0;
        for (int num : nums) {
            if (num < 0) {
                minus++;
            }
        }
        int remain = k - minus;
        if (minus > k) {
            // 把前k个小的负数翻转
            for (int i = 0; i < k; i++) {
                nums[i] = -nums[i];
            }
            return sum(nums);
        } else if (minus < k & minus >= 1) { // 有负数

            if (remain % 2 == 0) {
                // 直接求和返回
            } else {
                // 全部求和再减去 nums[minus-1] 位置最小的数
            }
            // 翻转 minus次
            for (int i = 0; i < minus; i++) {
                nums[i] = -nums[i];
            }
            return sum(nums) - (remain % 2 == 0 ? 0 : nums[minus - 1]);
        } else if (minus == k) {
            return sum(nums);
        } else { // minus =0 的情况 没有负数
            int sub = remain % 2 == 0 ? 0 : nums[0];
            int ret = sum(nums) - sub;
            System.out.println(ret);
            return ret;
        }
        // 统计负数 数字的个数，看当前k次是否能把所有负数翻转过来，

        // 正好相等
        // return -1;
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
        int k = 1;
        System.out.println(largestSumAfterKNegations(nums, k));
    }
}
