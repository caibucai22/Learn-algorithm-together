/**
 * @author Csy
 * @Classname LeetCode479
 * @date 2022-04-16 10:34
 * @Description TODO
 */
public class LeetCode479 {

    public static void main(String[] args) {
        /**
         * 给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
         */
    }

}

class Solution479 {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int ret = 0;
        long up = (int) Math.pow(10, n) - 1;
        for (long i = up; ret == 0; i--) { // 判断条件 ret == 0
            long left = i;
            long p = i;
            // System.out.print(p+" ");
            while (left != 0) {
                p = p * 10 + (left % 10);
                left /= 10;
            }
            // System.out.println(p);
            for (long x = up; x * x >= p; x--) {
                if (p % x == 0) {
                    ret = (int) (p % 1337); // 加()后再转int
                    break;
                }
            }
        }
        return ret;

    }
}