package sort;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname SortTest01
 * @date 2021/9/15 22:02
 * @Description TODO
 */
public class SortTest01 {

    public static int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index >= 0) {
            return index;
        } else {
            index = 0;
            while (index < nums.length&&target > nums[index]  ) {
                System.out.println(index);
                index++;
            }
            return index;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 4;
        System.out.println(searchInsert(nums, target));
    }
}
