import java.util.ArrayList;
import java.util.List;

/**
 * @author Csy
 * @Classname LeetCode587
 * @date 2022-04-23 12:18
 * @Description  587 围栅栏
 */
public class LeetCode587 {

    public static void main(String[] args) {

    }

}


class Solution {

    // JARVIS 算法 凸包

    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        int leftMost = 0;
        for (int i = 0; i < n; i++) {
            if (trees[i][0] < trees[leftMost][0]) {
                leftMost = i;
            }
        }

        List<int[]> res = new ArrayList<int[]>();
        boolean[] visit = new boolean[n];
        int p = leftMost;
        do {
            int q = (p + 1) % n;
            for (int r = 0; r < n; r++) {
                /* 如果 r 在 pq 的右侧，则 q = r */
                if (cross(trees[p], trees[q], trees[r]) < 0) {
                    q = r;
                }
            }
            /* 是否存在点 i, 使得 p 、q 、i 在同一条直线上 */
            for (int i = 0; i < n; i++) {
                if (visit[i] || i == p || i == q) {
                    continue;
                }
                if (cross(trees[p], trees[q], trees[i]) == 0) {
                    res.add(trees[i]);
                    visit[i] = true;
                }
            }
            if  (!visit[q]) {
                res.add(trees[q]);
                visit[q] = true;
            }
            p = q;
        } while (p != leftMost);
        return res.toArray(new int[][]{});
    }

    public int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }
}
