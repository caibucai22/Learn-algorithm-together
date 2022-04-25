import java.util.Random;

/**
 * @author Csy
 * @Classname LeetCode398
 * @date 2022-04-25 21:13
 * @Description TODO 随机数索引
 */
public class LeetCode398 {

    public static void main(String[] args) {

    }
}

class Solution398 {
    private int[] nums;

    public Solution398(int[] nums) {
        this.nums = nums;
    }

//    一次遍历
    public int pick(int target) {
        int count = 0;
        int idx = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                count++;
                if(new Random().nextInt(count) == 0){
                    idx = i;
                }
            }
        }

        return idx;
    }

//  两次遍历
    public int pick2(int target) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target)count++;
        }
        int idx = new Random().nextInt(count)+1;
        count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                count++;
                if(idx == count)return i;
            }
        }
        return -1;
    }
}