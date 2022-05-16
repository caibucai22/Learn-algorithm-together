package 二分查找;

/**
 * @author Csy
 * @Classname BinarySearchTest01
 * @date 2022-04-07 19:03
 * @Description TODO
 *
 * 当查找target为边界时 最后一个小于 target 的位置 就是 target位置
 * 第一个大于target位置也是target位置
 */
public class BinarySearchTest01 {


    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 7, 7, 8, 9, 10};
        int target = 1;
        int firstEqual = firstEqual(test, target);
        int lastEqual = lastEqual(test, target);
        int lastSmall = lastSmall(test, target);
        int firstBig = firstBig(test, target);

        System.out.println("第一个等于target的位置：test[" + firstEqual + "] =" + test[firstEqual]);
        System.out.println("最后一个等于target的位置：test[" + lastEqual + "] = " + test[lastEqual]);
        System.out.println("最后一个小于target的位置：test[" + lastSmall + "] = " + test[lastSmall]);
        System.out.println("第一个大于target的位置：test[" + firstBig + "] = " + test[firstBig]);
    }

    public static int firstEqual(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (a[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static int lastEqual(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (a[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    public static int firstBig(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);
            // 找a中最后一个小于t的
            if (a[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static int lastSmall(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            // 找a中最后一个小于t的
            if (a[mid] < target) l = mid;
            else r = mid - 1;
        }
        return l;
    }

}
