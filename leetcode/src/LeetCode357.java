/**
 * @author Csy
 * @Classname LeetCode357
 * @date 2022-04-11 9:52
 * @Description TODO
 */
public class LeetCode357 {

    public static void main(String[] args) {
        int n = 2;
        Solution357 s = new Solution357();
        int i = s.countNumbersWithUniqueDigits(2);
        System.out.println(i);
    }

}


class Solution357 {

    public int countNumbersWithUniqueDigits1(int n) {
        // 纯纯暴力
        for (int i = 0; i <= n; i++) {
            if (check(i)) ret++;
        }
        return 0;
    }

    private boolean check(int num) {
        return true;
    }


    // 回溯
    int ret = 0;
    boolean[] st = new boolean[10];

    public int countNumbersWithUniqueDigits(int n) {
        long max = (long) Math.pow(10, n);
        return dfs(0, max);
    }

    public int dfs(long cur, long max) {
        if (cur >= max) {
            return 0;
        }
        int ret = 1;
        for (int i = 0; i <= 9; i++) {
            if (cur == 0 && i == 0) continue; // 去掉前导0
            if (!st[i]) {
                st[i] = true;
                // cur = cur*10 +i; //
                // ret += dfs(cur,max);
                ret += dfs(cur * 10 + i, max);
                st[i] = false;
            }
        }
        return ret;
    }

}