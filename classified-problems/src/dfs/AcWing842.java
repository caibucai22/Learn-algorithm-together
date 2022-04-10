package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Csy
 * @Classname AcWing842
 * @date 2022-03-10 10:52
 * @Description AcWing 842. 排列数字  https://www.acwing.com/activity/content/code/content/47087/
 */
public class AcWing842 {

    //

    static final int N = 10;
    static int n;
    static boolean[] st;
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        st = new boolean[n];
        dfs(0, path);

    }

    public static void dfs(int idx, List<Integer> path) {
        if (path.size() == n) {
            for (int i = 0; i < path.size(); i++) {
                System.out.printf("%d ", path.get(i));
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
//            if (((state >> i) & 1) != 1) { //
//                // 表示这个数还没使用过 才进入
//                // 这里使用的是状态压缩 用位运算来判断
//                path.add(i + 1);
//
//                // state+(1 << i) 更新状态 表示已经使用
//                dfs(idx + 1, state + (1 << i), path);
//
//                //
//                state = (state >> i)&0;
//
//            }

            if (!st[i]) {
                path.add(i + 1);
                st[i] = true;
                dfs(idx + 1, path);
                st[i] = false;
                path.remove(path.size()-1);
            }
        }
    }


    /**
     * 测试 3 得到的结果
     * 1 2 3
     * 1 2 3 3 2
     * 1 2 3 3 2 2 1 3
     * 1 2 3 3 2 2 1 3 3 1
     * 1 2 3 3 2 2 1 3 3 1 3 1 2
     * 1 2 3 3 2 2 1 3 3 1 3 1 2 2 1
     *
     *
     * 出现这种问题的分析
     * 与在LeetCode上写的全排序不同，那里使用的是 回溯算法 这里没有回溯
     */
}
