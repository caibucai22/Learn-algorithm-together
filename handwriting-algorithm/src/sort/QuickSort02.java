package sort;

/**
 * @author Csy
 * @Classname QuickSort02
 * @date 2022-01-29 14:45
 * @Description TODO
 */
public class QuickSort02 {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.printf("%d ", i);
        }

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int q = partition(arr, left, right);
            quickSort(arr, left, q - 1);
            quickSort(arr, q + 1, right);
        }
    }

    private static int partition(int[] arr, int p, int r) {

        int pivot = arr[p];
        int left = p + 1;
        int right = r;
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }

            // 此时 left 指向第一个大于 pivot 的数, right 指向第一个小于 pivot 的数
            if (left < right) {
                swap(arr, left, right);
            }

//            if操作是为了防止越界
        }

//        退出循环后，此时left和right 交错 right指向最后一个小于 pivot 的数，进行交换
        swap(arr, right, p);
        return right;
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
