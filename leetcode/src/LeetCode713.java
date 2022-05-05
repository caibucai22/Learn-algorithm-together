import java.util.Arrays;

/**
 * @author Csy
 * @Classname LeetCode713
 * @date 2022-05-05 13:56
 * @Description TODO
 */
public class LeetCode713 {

    public static void main(String[] args) {
        int[] test = {10,5,2,6};
        int k = 100;
        Solution713 s = new Solution713();
        int i = s.numSubarrayProductLessThanK(test, k);
        System.out.println(i);
    }

}

class Solution713 {

    // 滑动窗口
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ret = 0;
        int n = nums.length;
        long mul = 1;
        for (int i = 0, j = 0; i < n && j < n; j++) {
            mul *= nums[j];
            // 超出窗口
            while (i <= j && mul >= k) {
                mul /= nums[i];
                i++;
            }
            // 窗口形成
            if (mul < k) {
                // ret++; 开始的错误理解
                ret += j - i + 1; // 关键
                /**
                 举个例子吧；
                 窗口左边界：l,窗口右边界：r
                 k=100
                 位置i：    0,  1, 2, 3
                 数组nums： 10, 5, 2, 6
                 窗口1(r=2)：   l, r
                 窗口1(r=3):    l,    r
                 窗口1中符合的有[5],[2],[5,2]
                 窗口2中符合的有[5],[2],[5,2],[6],[2,6],[5,2,6]
                 可以看出，
                 窗口2对比窗口1多出来的数组都是由于窗口右滑一次所带来的，即多出来的那几个必然是包含新窗口的边界r的
                 */
            }
        }
        return ret;
    }

//    暴力解法
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int ret = 0;
        long mul = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 求出 i-j 子数组的乘积
                mul *= nums[j];
                if (mul < k) {
                    ret++;
                    // mul = 1;
                }
            }
            // reset
            mul = 1;

        }
        return ret;
    }
}