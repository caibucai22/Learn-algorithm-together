package day12;

/**
 * @author Csy
 * @Classname _01_堆排序
 * @date 2022-01-30 19:51
 * @Description TODO
 */
public class _01_堆排序 {

    public static void main(String[] args) {
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8,9};
        int[] arr = {6, 7, 8, 3, 1, 2, 9};

        heapSort(arr);
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }


    public static void heapSort(int[] arr) {
        buildHeap(arr);

        // 这里的 x >= 0  多个=，重复了一次最后自己和自己交换，
        for (int x = arr.length - 1; x >= 0; x--) {
            // 将0号元素和最后一个元素交换
            int tmp = arr[0];
            arr[0] = arr[x];
            arr[x] = tmp;


            // 调整

            // 这里的 x 之前写成了 x-1

            fixHeap(arr, 0, x);
        }
    }

    private static void buildHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            fixHeap(arr, i, arr.length);
        }
    }

    private static void fixHeap(int[] arr, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 保留最小节点的下标
//        int min = -1;

        // 判断越界

        // 如果左孩子越界，显然右孩子也越界，则i为叶子节点
        if (left >= length) {
            return;
        }
        // 运行到这里，则表明左孩子未越界，默认左孩子为最小
        int min = left;

        // 进一步判断 如果右孩子越界，就是 左孩子最小
        if (right >= length) {
            min = left;
        } else {
            // 未越界 进行进一步比较
            if (arr[left] > arr[right]) {
                min = right;
            }
        }

        // 得到左右孩子较小的一个，判断是否进行调整
        if (arr[i] <= arr[min]) {
            return;
        }

        //进行交换
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;


        // 进行递归处理，防止调整后影响到下面节点状态
        fixHeap(arr, min, length);

        // 上面的if判断 也是递归的出口

    }
}