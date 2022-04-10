package day06;

/**
 * @author Csy
 * @Classname _01_快速排序
 * @date 2022-01-24 10:58
 * @Description TODO
 */
public class _01_快速排序 {

    public static void main(String[] args) {
        int[] arr = {1,9, 8, 7, 6, 5, 4, 3, 2, 1};
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
        int sp = p+1;
        int bigger = r;
        while (sp <= bigger) {
            if (A[sp] <= pivot) { // 小于主元 左指针右移
                sp++;
            } else {
                swap(A, sp, bigger); // 扫描元素大于主元 右指针左移
                bigger--;
            }
        }
        swap(A, p, bigger);
        return bigger;

    }

    private static void swap(int[] a, int i, int bigger) {

        int tmp = a[i];
        a[i] = a[bigger];
        a[bigger] = tmp;
    }
}
