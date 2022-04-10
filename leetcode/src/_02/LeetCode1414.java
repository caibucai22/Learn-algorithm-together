package _02;

/**
 * @author Csy
 * @Classname LeetCode1414
 * @date 2022-02-09 16:43
 * @Description TODO
 */
public class LeetCode1414 {

    public static void main(String[] args) {
        int i = Solution1414.findMinFibonacciNumbers(8);
        System.out.printf("%d ", i);
    }
}

class Solution1414 {

    public static int findMinFibonacciNumbers(int k) {
        // 也就是 找到 和为k 的斐波那契数字组合中 所用数字最少的 组合

        // 不可能去生成一个斐波那契数列

        // 根据提示 贪心
        // 找到一个距离 k 最近的 斐波那契数 然后减去 从大到小选取
        // 也就是逆斐波那契数列

        // 然后一直进行遍历 直到 k 减为0

        // 感觉可以用递归来写
        if (k == 1) {
            return 1;
        } else if (k == 0) {
            return 0;
        }
        int a = 1, b = 1;
        int tmp = 0;
        while (tmp <= k) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        // 退出循环时，b就是离k最近的一个数
//        k -= a;
        return findMinFibonacciNumbers(k-a) + 1;

    }
}