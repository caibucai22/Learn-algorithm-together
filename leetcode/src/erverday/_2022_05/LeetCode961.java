package erverday._2022_05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Csy
 * @Classname LeetCode961
 * @date 2022-05-24 21:31
 * @Description TODO
 */
public class LeetCode961 {
}


class Solution961 {
    public int repeatedNTimes(int[] nums) {
        // n的大小 只有2-5000 可以使用hash表进行统计
        Map<Integer, Integer> hash = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
            if (hash.get(num) == n / 2) return num;
        }
        return -1;
    }
}
