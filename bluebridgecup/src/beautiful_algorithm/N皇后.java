package beautiful_algorithm;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname N皇后
 * @date 2022-03-26 22:34
 * @Description TODO
 */
public class N皇后 {
    static int n;
    static int cnt;

    static int[] rec;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        rec = new int[n];
        dfs(0);
        System.out.println(cnt);
    }

    /**
     * @param row 当前正在处理的行
     */
    private static void dfs(int row) {
        if (row == n) {
            if(cnt < 3){
                for (int col : rec) {
                    System.out.print((col + 1) + " ");
                }
                System.out.println();
            }

            cnt++;
            return;
        }
        //依次尝试在某列上放一个皇后
        for (int col = 0; col < n; col++) {
            boolean ok = true;
            //检验这个皇后是否和之前已经放置的皇后有冲突
            for (int i = 0; i < row; i++) {
                if (rec[i] == col || i + rec[i] == row + col || rec[i] - i == col - row) {
                    ok = false;
                    break;
                }
            }
            /*=======这里可以认为是剪枝=======*/
            //这一行的这一列可以放
            if (ok) {
                rec[row] = col; //标记
                dfs(row + 1); //继续找下一行
                // rec[row]=0; //恢复原状，这种解法这里是否恢复状态都行，为什么？
            }
        }
    }

}
