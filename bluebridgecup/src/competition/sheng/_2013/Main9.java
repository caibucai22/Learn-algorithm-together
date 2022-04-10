package competition.sheng._2013;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname Main9
 * @date 2022-03-21 19:58
 * @Description TODO
 */
public class Main9 {

    // 带分数

    static int N = -1;
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        backTrack(0, arr);
        System.out.println(ret);
    }


    public static void backTrack(int start, int[] arr) {
        if (start == arr.length) {

//            for (int i : arr) {
//                System.out.printf("%d ", i);
//            }
//            System.out.println();

            check(arr);
            return;

        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);

            backTrack(start + 1, arr);

            // recover
            swap(arr, i, start);
        }
    }

    private static void check(int[] arr) {

        // 枚举 + / 位置
        for (int i = 1; i <= 7; i++) {
            int a = toInt(arr, 0, i - 1);
            // 优化
            if (a > N) {
                return;
            }

            for (int j = i + 1; j <= 8; j++) {
                int b = toInt(arr, i, j - 1);
                int c = toInt(arr, j, 8);
                // 这个 b%c 不加就不对
                if (b % c == 0 && N == a + b / c) {
                    ret++;
                }
            }
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static int toInt(int[] arr, int start, int end) {
        // 从i到j的数转换为数字
        StringBuffer sb = new StringBuffer();
        for (int i = start; i <= end; i++) {
            sb.append(arr[i]);
        }

        return Integer.valueOf(sb.toString());
    }


}
