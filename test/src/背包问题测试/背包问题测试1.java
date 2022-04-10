package 背包问题测试;

/**
 * @author Csy
 * @Classname 背包问题测试1
 * @date 2022-04-03 18:51
 * @Description TODO
 */
public class 背包问题测试1 {

    public static void main(String[] args) {
        /**
         * 测试对于排列问题和组合问题f[] 的变化情况
         */

        // 排列问题 先容量后物品
        // 硬币兑换问题
        int[] good = {1, 2, 5};
        int target = 3;


        int[] f = new int[target + 1];
        int[] f2 = new int[target + 1];
        f[0] = 1;
        f2[0] = 1;

        System.out.println("先容量后物品 排列数");
        System.out.println("good                  1 2 5");
        // 3 的排列数有
        for (int i = 0; i <= target; i++) {
            System.out.print("容量为：f[" + i + "] 变化情况 ");
            for (int j = 0; j < good.length; j++) {
                if (i >= good[j]) {
                    f[i] += f[i - good[j]];
                }
                System.out.print(f[i] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();

        // 先物品后容量
        System.out.println("先物品后容量 组合数");
        System.out.println("容量                  0 1 2 3 4 5");
        for (int j = 0; j < good.length; j++) {
            System.out.print("物品：good[" + j + "] = "+good[j] +"遍历 ");
            for (int i = 0; i <= target; i++) {
                if (i >= good[j]) {
                    f2[i] += f2[i - good[j]];
                }
                System.out.print(f2[i] + " ");
            }
            System.out.println();
        }
    }

}
