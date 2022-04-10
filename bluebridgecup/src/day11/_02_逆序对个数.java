package day11;

import java.io.PipedReader;

/**
 * @author Csy
 * @Classname _02_逆序对个数
 * @date 2022-01-29 13:30
 * @Description TODO
 */
public class _02_逆序对个数 {

    private static int[] help;
    private static int niXu;

    public static void main(String[] args) {

        /**
         * 左边大，右边小
         *  2 5 1 3 4
         *  2 1,5 1，5 3,5 4
         *
         *
         *  利用归并排序 在合并的过程中，统计逆序对个数
         *  左右两个序列 有序 从小到大 当左边大 右边小，此时左边序列 均大于 当前右边，与其
         *  构成逆序对
         */

//        int[] arr = {2, 3, 1, 7, 6, 5, 4, 1};
        int[] arr = {37,40,48,90,32,5,12,3,44,13};
        help = new int[arr.length];
        niXu = 0;
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println(niXu);
    }

    private static void sort(int[] arr, int p, int r) {
        if (p < r) {
            int mid = p + ((r - p) >> 1);
            sort(arr, p, mid);
            sort(arr, mid + 1, r);
            merge(arr, p, mid, r);
        }
    }

    private static void merge(int[] arr, int p, int mid, int r) {
        System.arraycopy(arr, p, help, p, r - p + 1);
        int left = p;
        int right = mid+1;
        int cur = p;


        while(left <= mid && right <= r){
            // 此时左边大 右边小
            if (help[left] > help[right]) {
                arr[cur] = help[right];
                right++;
                cur++;

                niXu += (mid-left+1);
            } else {
                arr[cur] = help[left];
                left++;
                cur++;
            }
        }

        // 对左边未处理完的 补到最后
        while(left <= mid){
            arr[cur] = help[left];
            cur++;
            left++;
        }
        while(right <= r){
            arr[cur] = help[right];
            cur++;
            right++;
        }
    }
}
