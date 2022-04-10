package sort;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname MergeSort2
 * @date 2022-04-06 14:45
 * @Description TODO
 */
public class MergeSort2 {

    static final int N = 100010;
    static int[] tmp;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        mergeSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) System.out.printf("%d ", a[i]);
    }

    private static void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;

        int mid = l + ((r - l) >> 1);
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);

        int i = l, j = mid + 1, idx = 0;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) tmp[idx++] = a[i];
            else tmp[idx++] = a[j];
        }

        while (i <= mid) tmp[idx++] = a[i];
        while (j <= r) tmp[idx++] = a[j];

        for (i = l, j = 0; i <= r; ) a[i++] = tmp[j++];
    }


}
