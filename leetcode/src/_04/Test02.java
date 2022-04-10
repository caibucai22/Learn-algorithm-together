package _04;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname Test02
 * @date 2022-03-03 20:29
 * @Description TODO
 */
public class Test02 {

    public static void main(String[] args) {
//        int test = 19;
//        System.out.println(isHappy(test));

        int[] test ={-1,0,1,1,55};
        int i = threeSumClosest(test, 3);
        System.out.println(i);
    }

    public static boolean isHappy(int n) {

        while (n != 1) {
            int tmp = 0;
            for (char ch : String.valueOf(n).toCharArray()) {
                tmp += (int) (ch - '0') * (int) (ch - '0');
            }
            n = tmp;
        }
        return true;
    }

    public static int threeSumClosest(int[] nums, int target) {

        // 双指针处理
        int n = nums.length;
        Arrays.sort(nums); // 排序
        // 用一个变量保存距离最近的和
        int close = nums[0]+nums[1]+nums[2];

        // 用外层 for 循环 i 也做为一个 指针
        for(int i = 0;i<n-2;i++){
            int l = i+1,r = n-1;
            while(l < r){
                int threeSum = nums[l]+nums[r]+nums[i];

                // 更新最近的和
                // close = Math.min(Math.abs(close - target),Math.abs(threeSum - target)); 这样更新是错误的 得到的close 是绝对值 不是真实距离
                if(Math.abs(close - target) > Math.abs(threeSum - target)){
                    close = threeSum;
                }

                // 这两个while循环 用来排除 重复元素(重复元素效果一样)
                while(l<r && nums[r] == nums[r-1]){
                    r--;
                }
                while(l<r && nums[l] == nums[l+1]){
                    l++;
                }

                if(threeSum == target){
                    return threeSum;
                }else if(threeSum-target > 0){
                    r--;
                }else if(threeSum - target < 0){
                    l++;
                }
            }
        }
        return close;
    }
}
