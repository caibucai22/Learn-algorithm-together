package _04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Csy
 * @Classname Test03
 * @date 2022-03-03 22:35
 * @Description TODO
 */
public class Test03 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 双指针  用两层循环的 i j 也作为指针 参与
        int n = nums.length;
        List<List<Integer>> ret = new ArrayList<>();

        for(int i=0;i<n-4;i++){
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j=i+1;j<n-3;j++){
                // 去重
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int l = j+1,r = n - 1;

                while(l<r){
                    // int sum = nums[i]+nums[j]+nums[l]+nums[r]; // 直接相加会溢出

                    if(nums[i]+nums[j] == target - (nums[l]+nums[r])){ // 使用减法 防止溢出


                        ret.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));

                        // 去除重复元素 不是在 while 里面进行去重 而是当满足条件后才去重
                        while(l<r && nums[r] == nums[r-1]){
                            r--;
                        }
                        while(l<r && nums[l] == nums[l+1]){
                            l++;
                        }
                    }else if(nums[i]+nums[j] > target - (nums[l]+nums[r])){
                        r--;
                    }else if(nums[i]+nums[j] < target - (nums[l]+nums[r])){
                        l++;
                    }
                }
            }
        }
        return ret;
    }
}
