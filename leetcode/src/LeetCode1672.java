/**
 * @author Csy
 * @Classname LeetCode1672
 * @date 2022-04-14 15:50
 * @Description TODO
 */
public class LeetCode1672 {

    public static void main(String[] args) {
        int[][] test = {{1,2,3},{3,4,5}};
        Solution1672 s = new Solution1672();
        int i = s.maximumWealth(test);
        System.out.println(i);
    }
}

class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int n = accounts.length, m = accounts[0].length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += accounts[i][j];
            }
            ret = Math.max(ret, sum);
        }
        return ret;
    }
}
