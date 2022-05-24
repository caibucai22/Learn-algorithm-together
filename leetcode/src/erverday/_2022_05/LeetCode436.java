package erverday._2022_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Csy
 * @Classname erverday._2022_05.LeetCode436
 * @date 2022-05-20 16:42
 * @Description TODO
 */
public class LeetCode436 {

    public static void main(String[] args) {

        int[][] test = {{1, 12}, {2, 9}, {3, 10}, {13, 14}, {15, 16}, {16, 17}};
        Solution436 s = new Solution436();
        int[] rightInterval = s.findRightInterval(test);
        Arrays.stream(rightInterval).forEach(o -> System.out.println(o));
    }
}

class Solution436 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ret = new int[n];
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Interval(intervals[i], i));
        }
        // 区间按start 从小到大
        Collections.sort(list, (o1, o2) -> o1.range[0] - o2.range[0]);

        for (int i = 0; i < n; i++) {
            Interval cur = list.get(i);
            int target = cur.range[1];
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + (r - l >> 1);
                //firstequal
                if (list.get(mid).range[0] >= target) {
                    r = mid;// 向左收缩区间
                } else {
                    l = mid + 1;
                }
            }
            if (list.get(l).range[0] >= target) ret[cur.idx] = list.get(l).idx;
            else ret[cur.idx] = -1;
        }
        return ret;
        // 整体时间复杂度 nlgn + nlgn
    }

}

class Interval {
    int[] range;
    int idx;

    public Interval(int[] range, int idx) {
        this.range = range;
        this.idx = idx;
    }
}