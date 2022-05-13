package sort;

/**
 * @author Csy
 * @Classname SelectSort
 * @date 2022-05-13 12:38
 * @Description TODO
 */
public class SelectSort {


    public static void sort(int[] a, int l, int r) {
        for (int i = l; i < r; i++) {
            int min = i;
            for (int j = i + 1; j <= r; j++) {
                if (a[min] > a[j]) min = j;
            }
            if (min != i) swap(a[min], a[i]);
        }
    }

    private static void swap(int a, int b) {
        int t = b;
        b = a;
        a = t;
    }

}
