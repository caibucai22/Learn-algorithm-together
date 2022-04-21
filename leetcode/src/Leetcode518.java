/**
 * @author Csy
 * @Classname Leetcode518
 * @date 2021-10-16 17:51
 * @Description TODO
 */
public class Leetcode518 {



    public static void main(String[] args) {
        Solution518 solution = new Solution518();
        int[] coins = {1,2,5};
        solution.change(5,coins);
    }
}
class Solution518 {
    public int change(int amount, int[] coins) {

        // 完全背包问题
        // 初始化
        int n = coins.length;
        int[][] f = new int[n+1][amount+1];
        f[0][0] = 1; // 很重要


        // 完全背包，先遍历物品后遍历容量,容量从小到大遍历
        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(i>coins[i-1]) {
                    f[i][j] = f[i - 1][j] + f[i - 1][j - coins[i - 1]];
                    // f[i][j] += f[i-1][j-coins[i-1]];
                }
                System.out.print(f[i][j]+" ");
            }
            System.out.println();
        }
        return f[n][amount];

    }


}
