/**
 * @author Csy
 * @Classname LeetCode378
 * @date 2022-05-18 21:54
 * @Description TODO
 */
public class LeetCode378 {

    public static void main(String[] args) {
        Solution378 s = new Solution378();

        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        int i = s.kthSmallest(matrix, k);
        System.out.println(i);
    }

}

class Solution378 {

    // 1. 两次二分
    public int kthSmallest(int[][] g, int k) {
        // 根据题意 g[0][0] 最小 g[m][n] 最大
        // 两次二分
        int m = g.length, n = g[0].length;
        int l = g[0][0], r = g[m - 1][n - 1];

        while (l < r) {
            int mid = l + (r - l >> 1);
            int cnt = 0;

            for (int i = 0; i < m; i++) {
                if (mid >= g[i][n - 1]) {
                    cnt += n;
                    continue;
                } else if (mid < g[i][0]) {
                    break;
                } else {
                    // 找该行小于等于mid其中的数的个数
                    // lastEqual

                    int low = 0, high = n - 1;
                    // 二分这里细节注意
                    while (low < high) {
                        int mid2 = low + (high - low + 1 >> 1);
                        if (g[i][mid2] <= mid) {
                            low = mid2; // 向右扩大范围
                        } else { // >
                            high = mid2 - 1;
                        }
                    }
                    cnt += (low + 1);
                }
            }
            // 二分这里，需要注意
            if (cnt >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 2. 堆排序
}
