package day07;

/**
 * @author Csy
 * @Classname _07_第k个小的数
 * @date 2022-01-25 11:05
 * @Description TODO
 */
public class _07_第k个小的数 {

    public static void main(String[] args) {

        // 维护一个 大小为k的有序序列


        // 排序后 返回第k个小

        // 快排的思想 中位数
        int[] arr = {1,2,3,4,5};
        int k = selectK(arr,0,arr.length-1,4);
        System.out.println(k);

    }

    /**
     * @param A
     * @param p 开始下标
     * @param r 结束下标
     * @param k
     * @return
     */
    public static int selectK(int[] A, int p, int r, int k) {
        int q = partition(A, p, r);

        //  中间值是第几个
        int qk = q - p + 1;
        if (qk == k) {
            return A[q];
        } else if (qk > k) {
            return selectK(A, p, q - 1, k);
        } else {
            return selectK(A, q + 1, r, k - qk);
        }
    }


    static int partition(int[] A, int p, int r) {
        int left = p+1;
        int right = r;
        int pivot = A[p];

        while(left <= right){
            while(left <= right && A[left] <= pivot){
                left++;
            }
            while(left <= right && A[right] > pivot){
                right--;
            }

            // 此时 left 指向 第一个比中间大的 right 指向第一个比中间小的
            if(left < right){
                swap(A,left,right);
            }

        }
        // 退出循环后此时 right指向最后一个比mid 小的 然后交换主元

        swap(A,pivot,right);
        return right;
    }

    private static void swap(int[] a, int left, int right) {

        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }
}
