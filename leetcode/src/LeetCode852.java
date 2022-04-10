/**
 * @author Csy
 * @Classname LeetCode852
 * @date 2021/10/14 20:48
 * @Description TODO
 */
public class LeetCode852 {

    public static int peakIndexInMountainArray(int[] arr) {
        // o(log(n)) 二分法
        int l = 1, r = arr.length - 2, ret = -1;
        while (l <= r) {
            int mid = (r + l) / 2;
            // if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1]){
            //     return mid;
            // }
            if (arr[mid] < arr[mid - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

//            if(arr[mid]>arr[mid+1]){
//                ret = mid;
//                r = mid - 1;
//            }else{
//                l = mid+1;
//            }
        }
        return ret;
    }


    // 比官方的理解更好
    public static int peakIndexInMountainArray2(int[] arr) {
        //二分法,先选择左右两下标。
        int left = 0;
        int right = arr.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            //左右都小于mid，说明mid是山峰。
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) break;

            //右边比左边高，说明山峰在右侧
            if (arr[mid + 1] > arr[mid]) left = mid;
                //右边比左边低，山峰在左侧
            else if (arr[mid + 1] < arr[mid]) right = mid;
        }
        return mid;
    }



    public static void main(String[] args) {
        int[] arr = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        int[] arr1 = {0,1,0};
        int peak = peakIndexInMountainArray2(arr1);
        System.out.println(peak);

    }
}
