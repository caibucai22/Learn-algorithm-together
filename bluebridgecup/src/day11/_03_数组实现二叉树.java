package day11;

/**
 * @author Csy
 * @Classname _03_数组实现二叉树
 * @date 2022-01-29 15:23
 * @Description TODO
 */
public class _03_数组实现二叉树 {

    public static void main(String[] args) {

    }

    /**
     * 先序遍历
     *
     * @param arr
     * @param i
     */
    public static void preOrder(int[] arr, int i) {
        if (i >= arr.length) {
            return;
        }

        // 根左右
        System.out.println(arr[i]);
        preOrder(arr, 2 * i + 1);
        preOrder(arr, 2 * i + 2);
    }

    /**
     * 中序遍历
     *
     * @param arr
     * @param i
     */
    public static void inOrder(int[] arr, int i) {
        if (i >= arr.length) {
            return;
        }

        // 左根右
        inOrder(arr, 2 * i + 1);
        System.out.println(arr[i]);
        inOrder(arr, 2 * i + 2);
    }

    /**
     * 后序遍历
     *
     * @param arr
     * @param i
     */
    public static void lastOrder(int[] arr, int i) {
        if (i >= arr.length) {
            return;
        }

        // 左右根
        lastOrder(arr, 2 * i + 1);
        lastOrder(arr, 2 * i + 2);
        System.out.println(arr[i]);

    }
}
