package erverday._2022_06;

/**
 * @author Csy
 * @Classname LeetCode829
 * @date 2022-06-07 17:02
 * @Description TODO
 */
public class LeetCode829 {
}

class Solution829 {

    // 暴力做法 只能算到 10^4
    public int consecutiveNumbersSum1(int n) {
        // 双指针吧 枚举每一个起始点 然后向后 找终点
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            int sum = i;
            if (sum == n) {
                ret++;
                break;
            }
            for (int j = i + 1; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    ret++;
                    break;
                }
            }
        }
        return ret;
    }

    // 数学
    public int consecutiveNumbersSum2(int n) {
        // (2k+x)*(x+1) == 2n x*x < 2n x 为连续数字个数
        int ret = 0;
        for (int x = 1; x * x < 2 * n; x++) {
            for (int k = 1; k <= n; k++) {
                // 这样算有问题 无法把单独的n 这个数算进去 会提前终止
                int tmp = (2 * k + x) * (x + 1);
                if (tmp == 2 * n) {
                    ret++;
                    System.out.println(k);
                } else if (tmp > 2 * n) break;
            }
        }
        return ret + 1;

        // (2*k + 1) == n;

    }

    // 数学
    public int consecutiveNumbersSum(int n) {
        // 设有k个数字 起始数字 为 i
        // i+...+ i+k-1 = k*i + (0+k-1)*k/2 = k*i + k*(k-1)/2
        // n = k*i + k*(k-1)/2;
        // n-k*(k-1)/2 = k*i  两边同时对k 取 余 只涉及 n 和 k 两个参数
        int sum = 0, cnt = 0;
        for (int k = 1; n - sum > 0; k++) {
            if ((n - sum) % k == 0) cnt++;
            sum += k;
        }
        return cnt;
    }
}