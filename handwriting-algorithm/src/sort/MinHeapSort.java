package sort;

/**
 * @author Csy
 * @Classname MinHeapSort
 * @date 2022-01-30 20:45
 * @Description TODO
 */
public class MinHeapSort {

    public static void main(String[] args) {
        int[] test = {2,3,5,9,1,0,8};
        sort(test);

        for (int i : test) {
            System.out.printf("%d ", i);
        }
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        buildMaxHeap(arr);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);

            fixHeap(arr, 0, i);
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }

    private static void fixHeap(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left >= len) {
            return;
        }
        int max = left;
        if (right >= len) {
            max = left;
        } else {
            if (arr[left] < arr[right]) {
                max = right;
            }
        }

        if (arr[i] > arr[max]) {
            return;
        }
        swap(arr, max, i);
        fixHeap(arr, max, len);
    }

    private static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            fixHeap(arr, i, arr.length);
        }
    }
}
