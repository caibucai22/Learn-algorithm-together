/**
 * @author Csy
 * @Classname LeetCode883
 * @date 2022-04-26 13:07
 * @Description TODO
 */
public class LeetCode883 {

    public static void main(String[] args) {
        int[][] test = {{1,2},{3,4}};
        Solution883 s = new Solution883();
        int i = s.projectionArea(test);
        System.out.println(i);
    }

}

class Solution883 {
    public int projectionArea(int[][] grid) {
        // 顶部 统计有格子覆盖的数目
        // 前面 按列遍历 找到列里面的最大值
        // 侧面 按行遍历 找到行里面的最大值
        int n = grid.length,m = grid[0].length;
        int front = 0,top = 0,side = 0;
        for(int i=0;i<n;i++){
            int rMax = grid[i][0];
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0)top++;
                rMax = Math.max(rMax,grid[i][j]);
            }
            side += rMax;
        }

        for(int j=0;j<m;j++){
            int cMax = grid[0][j];
            for(int i=0;i<n;i++){
                cMax = Math.max(cMax,grid[i][j]);
            }
            front += cMax;
        }
        return front+top+side;
    }
}
