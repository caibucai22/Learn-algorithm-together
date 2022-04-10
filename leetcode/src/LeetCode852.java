/**
 * @author Csy
 * @Classname LeetCode852
 * @date 2021/10/14 20:48
 * @Description TODO
 */
public class LeetCode852 {

    public static int peakIndexInMountainArray(int[] arr) {
        // o(log(n)) ���ַ�
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


    // �ȹٷ���������
    public static int peakIndexInMountainArray2(int[] arr) {
        //���ַ�,��ѡ���������±ꡣ
        int left = 0;
        int right = arr.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            //���Ҷ�С��mid��˵��mid��ɽ�塣
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) break;

            //�ұ߱���߸ߣ�˵��ɽ�����Ҳ�
            if (arr[mid + 1] > arr[mid]) left = mid;
                //�ұ߱���ߵͣ�ɽ�������
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
