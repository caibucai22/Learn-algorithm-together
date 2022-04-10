package leetcode;

/**
 * @author Csy
 * @Classname Test搜索旋转排序数组
 * @date 2022-04-07 12:33
 * @Description TODO
 */
public class Test搜索旋转排序数组 {


    public static void main(String[] args) {
        int[] nums = {3,1}; int target = 1;
        Solution33 s = new Solution33();
        int i = s.search(nums, target);
        System.out.println(i);

    }

}

class Solution33 {
    public int search(int[] nums, int target) {
        // 寻找山顶 在山顶两边进行二分查找
        int top = 0;
        int topV = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > topV) {
                topV = nums[i];
                top = i;
            }
        }

        int l = 0, r = nums.length - 1;
        int t1 = top, t2 = top+1;
        while (l < t1) {
            int mid = l + (t1 - l >> 1);
            // 找到第一个 = target 的数
            if (nums[mid] >= target) t1 = mid;
            else l = mid + 1;
        }
        System.out.println(t1);
        if (nums[t1] == target) return t1;

        while(t2 < r){
            int mid = t2 + (r - t2>> 1);
            if(nums[mid] >= target)r = mid;
            else t2 = mid+1;
        }
        System.out.println(t2);
        if (nums[t2] == target) return t2;


        return -1;
    }
}
