package sort;

import javafx.scene.shape.HLineTo;

import java.io.PipedReader;

/**
 * @author Csy
 * @Classname MergeSort
 * @date 2022-01-29 14:34
 * @Description TODO
 */
public class MergeSort {
    /**
     * 拆分容易，合并困难
     * o nlgn 需要辅助空间
     */

    private static int[] helper;

    public static void main(String[] args) {
        int[] arr = {9, 8, 6, 5, 4, 3, 2, 1,1,2};
        mergeSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.printf("%d ",i );
        }

    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + ((high - low) >> 1);
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        helper = new int[arr.length];
        System.arraycopy(arr, low, helper, low, high - low + 1);

        int left = low;
        int right = mid + 1;
        int cur = low;

        while(left <= mid && right <= high){
            if(helper[left] <= helper[right]){
                arr[cur] = helper[left];
                cur++;
                left++;
            }else{
                arr[cur] = helper[right];
                cur++;
                right++;
            }
        }

        // 对于剩下未比较完的，直接补全到后面

        while(left <= mid){
            arr[cur] = helper[left];
            cur++;
            left++;
        }

        while(right <= high){
            arr[cur] = helper[right];
            cur++;
            right++;
        }

    }
}
