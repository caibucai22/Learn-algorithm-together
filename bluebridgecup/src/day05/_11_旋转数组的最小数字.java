package day05;

/**
 * @author Csy
 * @Classname _11_旋转数组的最小数字
 * @date 2022-01-23 10:07
 * @Description （改造二分法）
 */
public class _11_旋转数组的最小数字 {

    public static void main(String[] args) {

        int[] arr = {3,4,5,1,2};

        // 下面方法不适合存在重复元素
    }

    static int min(int[] arr){
        int begin = 0;
        int end = arr.length-1;

        if(arr[begin]< arr[end]){
            return arr[begin];
        }

        while(begin+1 <end){
            int mid = begin + ((end-begin)>>1);
            // 如果存在


            // 要么左侧有序，要么右侧有序

            // 目标是找无序的一侧

            if(arr[mid] >= arr[begin]){
                // 左侧有序，目标在右侧
                begin = mid;
            }else{
                // 右侧有序，目标在左侧
                end = mid;
            }
        }

        // 退出后，begin 和 end 相邻
        return arr[end];
    }
}
