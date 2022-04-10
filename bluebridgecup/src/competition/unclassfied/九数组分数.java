package competition.unclassfied;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname 九数组分数
 * @date 2022-03-24 12:50
 * @Description TODO
 */
public class 九数组分数 {

    static int[] a;
    static boolean[] used;

    public static void main(String[] args) {

        a = new int[9];
        used = new boolean[9 + 1];

        Arrays.fill(a, -1);

        dfs(0);

//        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int i = listToint(test, 2, 9);
//        System.out.printf("%d", i);

    }

    private static void dfs(int start) {
        if (start == 9) {
            check(a); //枚举除好位置 检查是否满足 组合是否值为1/3
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                a[start] = i;
                dfs(start + 1);
                a[start] = -1;
                used[i] = false;
            }
        }
    }

    private static void check(int[] a) {
        // 枚举除号位置
        // 1 2 3 4 5 6 7 8 9
        // 0 1 2 3 4 5 6 7 8
        for (int i = 1; i < a.length - 1; i++) {
            int left = listToint(a, 0, i); // 不包括i
            int right = listToint(a, i, a.length);
            if (left * 3 == right) {
                for (int num : a) {
                    System.out.printf("%d ", num);
                }
                System.out.println();
            }
        }
    }

    private static int listToint(int[] a, int l, int r) {
        int ret = 0;
        for (int i = l; i <= r - 1; i++) {
            ret = ret * 10 + a[i];
        }
        return ret;
    }


}
