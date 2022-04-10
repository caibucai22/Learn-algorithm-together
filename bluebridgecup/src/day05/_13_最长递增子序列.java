package day05;

/**
 * @author Csy
 * @Classname _13_最长递增子序列
 * @date 2022-01-23 10:50
 * @Description TODO 应该是最长连续递增子序列
 */
public class _13_最长递增子序列 {


    public static void main(String[] args) {


        int[] arr = {1, 2, 5, 6, 7, 9, 6, 2, 3, 4, 5, 1, 7, 8};
        int cur = 0, pre = cur + 1;
        int ret = 1;
        int count = 1;
        while (pre < arr.length) {
            if (arr[pre] > arr[pre - 1]) {
                count++;
                ret = Math.max(ret, count);
            } else {
                count = 1;
                cur = pre;
            }
            pre++;
        }
        System.out.println(ret);
    }
}
