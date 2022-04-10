package day06;

import java.sql.PreparedStatement;

/**
 * @author Csy
 * @Classname _02_快速排序_双向扫描
 * @date 2022-01-24 11:09
 * @Description 首尾指针向中间扫
 */
public class _02_快速排序_双向扫描 {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1,100};
        QuickSort(arr,0,arr.length-1);

        for (int i : arr) {
            System.out.print(i+" ");
        }

    }


    static void QuickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A,p,r);
            QuickSort(A, p, q - 1);
            QuickSort(A, q + 1, r);
        }
    }

    static int partition(int[] A,int p,int r) {
        int pivot = A[p];
        int left = p+1;
        int right = r;
        while(left <= right){
            while(left <= right && A[left] <= pivot){
                left++;
            }
            while(left <= right && A[right] > pivot){
                right--;
            }
            // 正常情况下此时left指向一个大于pivot，right 指向一个小于等于 pivot，进行交换
            if(left <= right){
                swap(A,left,right);
            }

            // 添加if 是为了防止越界

        }

        // 退出循环，最后的状况是 right 指向最后一个小的， left 指向第一个大的
        swap(A,p,right);
        return right;

    }

    private static void swap(int[] a, int i, int bigger) {

        int tmp = a[i];
        a[i] = a[bigger];
        a[bigger] = tmp;
    }
}
