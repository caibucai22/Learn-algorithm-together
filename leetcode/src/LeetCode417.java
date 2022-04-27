import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Csy
 * @Classname LeetCode417
 * @date 2022-04-27 13:12
 * @Description TODO
 */
public class LeetCode417 {

    public static void main(String[] args) {

        int[][] test = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        Solution417 s = new Solution417();
        List<List<Integer>> lists = s.pacificAtlantic(test);
    }

}


class Solution417 {
    /**
     建立两个矩阵Atlantic和Pacific, 当Atlantic[i][j]和Pacific[i][j]同时为true时表示该位置可以同时到达Atlantic和Pacific
     便历时的技巧为: 只需要从四个边界开始遍历即可(类似泛洪的思想, 只要可以从边界出发到达, 就说明该位置的水可以流向对应的海洋)
     **/
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        int m = matrix.length;
        if(m < 1) return ret;
        int n = matrix[0].length;
        boolean[][] Pacific = new boolean[m][n];
        boolean[][] Atlantic = new boolean[m][n];
        for(int i = 0; i < m; ++i) {
            dfs(matrix, i, 0, Pacific, matrix[i][0]);
            dfs(matrix, i, n-1, Atlantic, matrix[i][n-1]);
        }
        for(int i = 0; i < n; ++i) {
            dfs(matrix, 0, i, Pacific, matrix[0][i]);
            dfs(matrix, m-1, i, Atlantic, matrix[m-1][i]);
        }
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j)
                if(Pacific[i][j] && Atlantic[i][j])
                    ret.add(Arrays.asList(i, j));
        }
        return ret;
    }

    private void dfs(int[][] m, int x, int y, boolean[][] visited, int pre) {
        if(x < 0 || y < 0 || x >= m.length || y >= m[0].length || visited[x][y] || m[x][y] < pre)
            return;
        visited[x][y] = true;
        dfs(m, x+1, y, visited, m[x][y]);
        dfs(m, x-1, y, visited, m[x][y]);
        dfs(m, x, y+1, visited, m[x][y]);
        dfs(m, x, y-1, visited, m[x][y]);
    }
}