package sort;


/**
 * @author Csy
 * @Classname Sort01
 * @date 2021/9/15 20:48
 * @Description TODO
 */
public class Sort01 {

    public static int binarySearch(int[] nums, int target) {
        // 使用二分法的前提是数组有序
        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
//            mid = (l + r) / 2;
//            mid = l + ((r - l) >> 1);
            mid = l + (r - l) / 2;
            // 这样写可以防止溢出
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return -1;
    }

    public static int binarySearch02(int[] nums,int target){
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 9, 9};

        System.out.println();
        System.out.println(binarySearch(nums, 7));
    }
}
