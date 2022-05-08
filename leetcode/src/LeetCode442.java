import java.util.ArrayList;
import java.util.List;

/**
 * @author Csy
 * @Classname LeetCode442
 * @date 2022-05-08 23:19
 * @Description TODO https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 */
public class LeetCode442 {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Solution442 s = new Solution442();
        List<Integer> duplicates = s.findDuplicates(nums);
        duplicates.forEach(o -> System.out.println(o));
    }
}


class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.add(x);
            }
        }
        return ans;
    }
}
