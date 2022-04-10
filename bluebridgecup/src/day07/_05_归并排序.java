package day07;


/**
 * @author Csy
 * @Classname _05_归并排序
 * @date 2022-01-25 10:28
 * @Description TODO
 */
public class _05_归并排序 {

    private static int[] help;

    public static void main(String[] args) {

        // 分解随意，合并重点

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 1};
        int[] test ={37,40,48,90,32,5,12,3,44,13};
//        help = new int[arr.length];
//        mergeSort(arr, 0, arr.length - 1);
//        for (int i : arr) {
//            System.out.printf("%d ", i);
//        }
        help = new int[test.length];
        mergeSort(test, 0, test.length - 1);
        for (int i : test) {
            System.out.printf("%d ", i);
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            // 位运算这里需要加括号，优先级无法保证
            int mid = low + ((high - low) >> 1);
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int p, int mid, int r) {
        System.arraycopy(arr, p, help, p, r - p + 1);

        int left = p;
        int right = mid + 1;
        int cur = p;

        while (left <= mid && right <= r) {
            if (help[left] > help[right]) {
                arr[cur] = help[right];
                right++;
                cur++;
            } else {
                arr[cur] = help[left];
                left++;
                cur++;
            }
        }

        // 如果 未比较完 剩余直接填充到后面
        while(left <= mid){
            arr[cur] = help[left];
            cur++;
            left++;
        }


        // 右边的可以不做处理，仍然在其正确的位置上
        while(right <= r){
            arr[cur] = help[right];
            cur++;
            right++;
        }
    }
}
