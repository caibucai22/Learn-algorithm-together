import java.util.ArrayList;
import java.util.List;

/**
 * @author Csy
 * @Classname Solution2055
 * @date 2022-03-08 23:49
 * @Description TODO
 */
public class LeetCode2055 {
    public static void main(String[] args) {
        Solution2055 s = new Solution2055();
        String str = "***|**|*****|**||**|*";
        int[][] b = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        int[] ints = s.platesBetweenCandles(str, b);

        for (int anInt : ints) {
            System.out.printf("%d ", anInt);
        }
    }
}

class Solution2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        // 分析数据范围 1-10^5 ，10^5 最大10^10
        int n = queries.length;
        int[] ret = new int[n + 1];
        char[] chs = s.toCharArray();
        int idx = 0;

        int[] preFix = new int[s.length()]; // 表示截止到i（包括i）有多少个盘子
        List<Integer> candix = new ArrayList<>();
        preFix[0] = chs[0] == '*' ? 1 : 0;

        // 特例
        if (chs[0] == '|') {
            candix.add(0);
        }

        for (int i = 1; i < s.length(); i++) {
            if (chs[i] == '*') {
                preFix[i] = preFix[i - 1] + 1;

            } else {
                preFix[i] = preFix[i - 1];
                candix.add(i); // 把蜡烛的位置也预处理出来
            }
        }


        for (int[] range : queries) {
            int l = range[0], r = range[1];
            int cnt = 0;
            // 这里使用双指针进行查找边界 进一步优化为二分查找
            // 二分查找需要排序 !!! 蜡烛的位置是递增的

            // 折半查找 离所给边界最近的蜡烛

            // 找到 >= l 的第一个数
            int ldx = binarySearchL(candix, l);
            // 找到 <= r 的最后一个数
            int rdx = binarySearchR(candix, r);

            // if()
            // 两个指针左右逼近
            // while(l<r && chs[l] != '|') {
            //     l++;
            // }
            // while(l<r && chs[r] != '|'){
            //     r--;
            // }

            // for(int i = l;i<r;i++){ // 这里进行优化 可以使用前缀和 储存到每个位置的 盘子数
            //     if(chs[i] == '*'){
            //         cnt++;
            //     }
            // }

            // ret[idx++] = cnt;

            // 优化成
            int pr = candix.get(rdx), pl = candix.get(ldx);
            ret[idx] = preFix[pr] - preFix[pl];
            idx++;
        }
        return ret;
        // 以上是暴力解法 n^2 超时
    }


    public int binarySearchL(List<Integer> candix, int tagret) {
        int l = -1, r = candix.size();

        while (l + 1 != r) {
            int mid = l + ((r - l) >> 1);
            // int midVal = candix.get(mid);

            // 将数组划分为 小于  和 大于 等于 的部分 然后返回 r
            if (tagret > mid) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }

    public int binarySearchR(List<Integer> candix, int tagret) {
        int l = -1, r = candix.size();

        while (l + 1 != r) {
            int mid = l + ((r - l) >> 1);
            // int midVal = candix.get(mid);

            // 将数组划分为 小于等于  和 大于  的部分 然后返回 l
            if (tagret < mid) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }
}
