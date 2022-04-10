package list2;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 八皇后
 * @date 2022-03-26 22:07
 * @Description TODO
 */
public class 八皇后 {

    static int cnt = 0;
    static int n;

    public static void main(String[] args) {
        // 6*6
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] g = new int[n]; // i 表示第几行 g[i] 表示第几列
        dfs(0, g);

        System.out.println(cnt);
    }

    private static void dfs(int row, int[] g) {
        if (row == n) {
            if (cnt < 3) {
                for (int i = 0; i < 6; i++) {
                    System.out.print((g[i]+1)+" ");
                }
                System.out.println();
            }
            cnt++;
            return;

        }

        for (int col = 0; col < n; col++) {
            if (check(g, row, col)) {
                g[row] = col;
                dfs(row + 1, g);

                // recover
                g[row] = -1;
            }
        }
    }


    private static boolean check(int[] g, int x, int y) {
        //检查行 列 对角线
        for (int i = 0; i < x; i++) {
            if (g[i] == y) return false;
            if (x - y == i - g[i]) return false;
            if (x + y == i + g[i]) return false;
        }
        return true;
    }

}
