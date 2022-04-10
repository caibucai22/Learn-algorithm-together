package competition.unclassfied2;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 激光炸弹
 * @date 2022-03-28 15:31
 * @Description TODO 容易内存爆炸  1.每次得到xy坐标 要去更新最大的边界 减少前缀和矩阵的遍历
 * 将数组重新定位到（1，1）开始 要不然会越界
 */
public class 激光炸弹 {


    static int N = 5010;
    static int[][] s = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        r = Math.min(5001, r);
        int row = -1, col = -1;
        row = col = r;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            int val = sc.nextInt();
            x++;
            y++;
            // 确定遍历范围 减少遍历
            row = Math.max(row, x);
            col = Math.max(col, y);
//            g[x + 1][y + 1] += val; // +1 扩大一下
            s[x][y] += val;
        }

        // 构建前缀和矩阵
        // +1 防止越界
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + s[i][j];
            }
        }

        int max = -1;
        for (int i = r; i <= row; i++) {
            for (int j = r; j <= col; j++) {
                // 减去的是边长r-1的矩形
                max = Math.max(max, s[i][j] - s[i - r][j] - s[i][j - r] + s[i - r][j - r]);
            }
        }

        System.out.println(max);
    }

}
