package erverday._2022_06;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname LeetCode875
 * @date 2022-06-07 17:01
 * @Description TODO
 */
public class LeetCode875 {
}

class Solution875 {

    public int minEatingSpeed(int[] piles, int h) {
        // 二分的方法 枚举
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while (l < r) {
            int mid = l + (r - l >> 1);
            int time = getTime(piles, mid);
            // 找到 k 的最小值 => time <= h
            if (time <= h) {// time <= h => k偏大 r 左移
                r = mid;
            } else { // time > h k偏小 l 右移
                l = mid + 1;
            }
        }
        return l;
    }

    private int getTime(int[] piles, int speed) {
        int time = 0;
        for (int p : piles) {
            time += (p + speed - 1) / speed;
        }
        return time;
    }
}