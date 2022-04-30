import java.util.Arrays;

/**
 * @author Csy
 * @Classname LeetCode908
 * @date 2022-04-30 13:26
 * @Description TODO
 */
public class LeetCode908 {


    public static void main(String[] args) {
        int[] test = {1, 3, 6};
        int k = 3;
        Solution908 s = new Solution908();
        int i = s.smallestRangeI(test, k);
        System.out.println(i);
    }

}

class Solution908 {


    public int smallestRangeI(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt() + k;
        int max = Arrays.stream(nums).max().getAsInt() - k;
        int ret = max - min;
        return ret >= 0 ? ret : 0;
    }


    // 想到了区间问题 单点修改 全区间的最大值 最小值

    // public int smallestRangeI(int[] nums, int k) {
    //     // 加还是不加 来影响 最大值 最小值 -> 最低分数
    //     int n = nums.length;
    //     // int min = Arrays.stream(nums).min().getAsInt();
    //     // int max = Arrays.stream(nums).max().getAsInt();
    //     int min = nums[0],max = nums[0];
    //     int ret = Integer.MAX_VALUE;

    //     for(int i=0;i<n;i++){
    //         for(int j=-k;j<=k;j++){
    //             // if()
    //             max = Math.max(max,nums[i]+j);
    //             min = Math.min(min,nums[i]+j);
    //             ret = Math.min(ret,max - min);
    //         }

    //     }
    //     return ret;
    // }
}