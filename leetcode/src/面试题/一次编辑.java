package 面试题;

/**
 * @author Csy
 * @Classname 一次编辑
 * @date 2022-05-13 13:33
 * @Description TODO
 */
public class 一次编辑 {

    public static void main(String[] args) {

        String a = "intention";
        String b = "execution";
        Solution s = new Solution();
        boolean b1 = s.oneEditAway(a, b);
    }

}

class Solution {
    public boolean oneEditAway(String first, String second) {
        // 可以用动态规划来写 字符距离
        int m = first.length();
        int n = second.length();
        int[][]  f = new int[m+1][n+1];

        // f[i][j] 表示从0-i 0-j 所需要的修改步数
        // 初始化
        for(int i=0;i<=n;i++)f[0][i] = i;
        for(int i=0;i<=m;i++)f[i][0] = i;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                char a = first.charAt(i-1);
                char b = second.charAt(j-1);

                if(a==b)f[i][j] = f[i-1][j-1]; // 相同不变
                else{
                    f[i][j] = Math.min(f[i-1][j],f[i][j-1])+1;// 添加 和 删除
                    f[i][j] = Math.min(f[i-1][j-1]+1,f[i][j]);
                }
            }
        }
        if(f[m][n] > 1)return false;
        return true;
    }
}
