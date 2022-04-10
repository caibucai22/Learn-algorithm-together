package search;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname BinarySearch
 * @date 2022-03-08 22:41
 * @Description TODO
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6,7,7,8,9};
        int search = search(test, 7);
        System.out.println(search);
//        Arrays.binarySearch()
    }

    // 找到第一个 >= target 的元素

    public static int search(int[] nums,int target){
        int l = 0,r = nums.length;

        // 将数组划分为小于target区域 和 >= target区域
        while(l+1 != r){
            int mid = l + ((r-l)>>1);

            if(nums[mid] < target){
                l = mid;
            }else{
                r = mid;
            }
        }
        return r;
    }

    // 找到最后一个 >= target 的元素

    public static int search2(int[] nums,int target){
        int l = -1,r = nums.length;
        // 将数据分成 <= target 的元素
        while(l+1 != r){
            int mid = l + ((r-l)>>1);

            if(nums[mid] > target){
                r = mid;
            }else{
                l = mid;
            }
        }
        return l;
    }
}
