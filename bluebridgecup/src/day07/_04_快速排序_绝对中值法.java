package day07;

/**
 * @author Csy
 * @Classname _04_快速排序_绝对中值法
 * @date 2022-01-25 10:10
 * @Description TODO
 */
public class _04_快速排序_绝对中值法 {

    public static void main(String[] args) {

        // 主元 居中 是我们想要的 此时 nlgn

        // 取第一个元素 当为最大值时 有可能退化为 n^2


    }

    static void QuickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            QuickSort(A, p, q - 1);
            QuickSort(A, q + 1, r);
        }
    }

    static int partition(int[] A, int p, int r) {


        // 优化 在 p r mid 之间 选一个中间值作为主元

        // 三点中值法

        int midIndex = p + (r - p) >> 1;
        int midValueIndex = -1;

        if (A[p] <= A[midIndex] && A[p] >= A[r]) {
            midValueIndex = p;
        } else if (A[p] <= A[midIndex] && A[r] >= A[p]) {
            midValueIndex = r;
        } else {
            midValueIndex = midIndex;
        }

        swap(A, p, midValueIndex);


        int pivot = A[p];
        int left = p + 1;
        int right = p;
        while (left <= right) {
            while (left <= right && A[left] <= pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            // 此时left指向一个大于pivot，right 指向一个小于等于 pivot，进行交换
            swap(A, left, right);
        }

        // 退出循环，最后的状况是 right 指向最后一个小的， left 指向第一个大的
        swap(A, p, right);
        return right;

    }

    private static void swap(int[] a, int i, int bigger) {

        int tmp = a[i];
        a[i] = a[bigger];
        a[bigger] = tmp;
    }
}
