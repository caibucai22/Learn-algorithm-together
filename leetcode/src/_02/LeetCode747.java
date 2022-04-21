package _02;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname LeetCode747
 * @date 2022-02-08 11:29
 * @Description TODO
 */
public class LeetCode747 {


    public static void main(String[] args) {
        int[] test = {1,0,0,0};

        // 忘记了二分查找需要是有序的，
        int i = Arrays.binarySearch(test,1);
        System.out.printf("%d ",i);

//        Solution747 solution = new Solution747();

//        System.out.printf("%d\n", solution.dominantIndex(test));
    }
}
class Solution747 {
    public int dominantIndex(int[] nums) {
        // 1. 排序
        // 如果他是第2大 的2倍，那么他就 至少是数组中每个其他数字的两倍
        int n = nums.length;
        int[] tmp = new int[n];
        System.arraycopy(nums,0,tmp,0,n);
        if(n == 1){
            return 0;
        }
        // Arrays.sort(nums); 不能这样做，这样改变了原始的下标，或者 这样做，然后做一下查找
        Arrays.sort(tmp);
        if(tmp[n-1] < 2*tmp[n-2]){
            return -1;
        }
        return  Arrays.binarySearch(nums,tmp[n-1]);
    }
}
