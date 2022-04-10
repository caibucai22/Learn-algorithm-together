/**
 * @author Csy
 * @Classname LeetCode1049
 * @date 2021/10/12 23:21
 * @Description TODO
 */
public class LeetCode1049 {

    public static int lastStoneWeightII(int[] stones) {

        // 数学分析
        // 转换为将两个石头堆尽可能分成均等份
        int sum = 0;
        for (int w : stones) {
            sum += w;
        }
        int target = sum  / 2;
        // 初始化
        int n = stones.length;
        int[][] f = new int[n + 1][150001];

        // 确定递推方程

        // 确定更新顺序，更新
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (stones[i - 1] > j) {
                    f[i][j] = f[i - 1][j];
                } else {

                    f[i][j] = Math.max(f[i - 1][j], f[i][j - stones[i - 1]] + stones[i - 1]);
                }
                System.out.print(f[i][j]+" ");
                if(j==target){
                    System.out.println();
                }
            }
        }


        return sum - f[n][target] - f[n][target];
    }

    public static void main(String[] args) {
        int[] stones = {31,26,33,21,40};
        System.out.println(lastStoneWeightII(stones));
    }
}
