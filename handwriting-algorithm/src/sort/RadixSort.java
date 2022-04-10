package sort;

import java.util.ArrayList;

/**
 * @author Csy
 * @Classname RadixSort
 * @date 2022-01-31 13:57
 * @Description TODO
 */
public class RadixSort {

    private static ArrayList<Integer>[] buckets = new ArrayList[10];

    static {
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }
    }


    public static void main(String[] args) {
        int[] test = {111,1,20,333,55,666,9,10000};
        sort(test);
        for (int i : test) {
            System.out.printf("%d ", i);
        }
    }

    public static void sort(int[] arr) {

        // 得到最大值
        int max = getMaxValue(arr);
        // 得到最大值位数
        int maxD = String.valueOf(max).length();

        // 按数位上的数进行收集
        for (int d = 1; d <= maxD; d++) {
            for (int i = 0; i < arr.length; i++) {
                int len = String.valueOf(arr[i]).length();
                if (d <= len) {
                    buckets[getDigitOn(arr[i], d)].add(arr[i]);
                } else {
                    buckets[0].add(arr[i]);
                }

            }
            // 收集完，按顺序恢复到原数组，并清空bucket
            int cur = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (int num : bucket) {
                    arr[cur++] = num;
                }
                bucket.clear();
            }
        }

    }

    private static int getDigitOn(int i, int d) {

        int len = String.valueOf(i).length();
        if (d > len) {
            System.out.println("位数越界");
            return -1;
        }
        return String.valueOf(i).charAt(len - d) - '0';

    }

    private static int getMaxValue(int[] arr) {

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
