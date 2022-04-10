package sort;

/**
 * @author Csy
 * @Classname MaxHeapSort
 * @date 2022-01-30 20:29
 * @Description TODO
 */
public class MaxHeapSort {

    public static void main(String[] args) {
        int[] test = {5,4,3,2,1};
        sort(test);

        for (int i : test) {
            System.out.printf("%d ", i);
        }
    }

    public static void sort(int[] arr) {
        buildMinHeap(arr);
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);

            fixHeap(arr, 0, i);
        }
    }

    private static void fixHeap(int[] arr, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left >= length) {
            return;
        }

        int min = left;
        if (right >= length) {
            min = left;
        } else {
            if (arr[right] < arr[left]) {
                min = right;
            }
        }

        if (arr[min] >= arr[i]) {
            return;
        }
        swap(arr, min, i);

        fixHeap(arr, min, length);
    }

    private static void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }

    private static void buildMinHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            fixHeap(arr, i, arr.length);
        }
    }
}
