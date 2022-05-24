package erverday._2022_05;

/**
 * @author Csy
 * @Classname erverday._2022_05.LeetCode668
 * @date 2022-05-18 21:51
 * @Description TODO
 */
public class LeetCode668 {
    public static void main(String[] args) {
        int m = 45, n = 12, k = 471;
        Solution668 s = new Solution668();
        int kthNumber = s.findKthNumber(m, n, k);
        System.out.println(kthNumber);
    }
}

class Solution668 {
    public int findKthNumber(int m, int n, int k) {

        // 根据官方题解的思想
        // 找出每一行中比 mid 小的数的个数 然后累加 确定这个数是第几个 与k进行比较
        // 放大缩小 范围 因为乘法表中的数每一行都是递增的 虽然每一列相对于上一列不是递增的

        int l = 1, r = m * n;
        while (l < r) {
            int mid = l + (r - l >> 1);
            // 统计每一行中小于等于mid的数
            int cnt = 0;
            for (int i = 1; i <= m; i++) {
                cnt += Math.min(mid / i, n);
            }
            // 比较

            // 二分细节不对
            // lastEqual
            // if(cnt > k){
            //     r = mid-1;
            // }else{
            //     l = mid;
            // }

            // firstEqual
            if (cnt >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
