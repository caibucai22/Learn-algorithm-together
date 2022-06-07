package erverday._2022_06;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname LeetCode473
 * @date 2022-06-07 17:02
 * @Description TODO
 */
public class LeetCode473 {
}

class Solution473 {
    int[] cnt = new int[4];

    public boolean makesquare(int[] matchsticks) {
        // 特判 如果不能被4整除
        int sum = 0;
        int n = matchsticks.length;
        for (int i = 0; i < n; i++) sum += matchsticks[i];
        if (n < 4 || sum % 4 != 0) return false;
        int len = sum / 4;
        // 根据提示 枚举每一根火柴属于那一条边
        Arrays.sort(matchsticks);
        if (matchsticks[n - 1] > len) return false;

        return dfs(0, matchsticks, len);
    }

    private boolean dfs(int u, int[] matchsticks, int len) {
        if (u == matchsticks.length) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (cnt[i] + matchsticks[u] <= len) {
                // 剪枝 很有效
                if (i == 0 || cnt[i] != cnt[i - 1]) {
                    cnt[i] += matchsticks[u];
                    if (dfs(u + 1, matchsticks, len)) return true;
                    // 放入失败 回溯
                    cnt[i] -= matchsticks[u];
                }
            }
        }
        return false;
    }
}