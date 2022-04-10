/**
 * @author Csy
 * @Classname Test分割回文串2
 * @date 2022-03-26 15:42
 * @Description TODO
 */
public class Test分割回文串2 {

    public static void main(String[] args) {
        String test = "aab";
        int i = new Solution().minCut(test);
        System.out.printf("%d ", i);
    }

}

class Solution {
    public int minCut(String s) {
        // 这道题的数据范围给到了2000 用回溯写过不了

        // 动态规划
        // 状态表示 集合：各种分割的方式 属性分割方式的次数
        // 状态计算 0-i = 0~i-1 + i //枚举分割位置 0-j j-i;
        // 0-j 是回文 不是会文
        // a a b;aa b;
        int[] f = new int[2010];
        // f[1] = 1; 初始化错误

        /**
         初始化问题：首先来看一下dp[0]应该是多少。
         dp[i]： 范围是[0, i]的回文子串，最少分割次数是dp[i]。
         那么dp[0]一定是0，长度为1的字符串最小分割次数就是0。这个是比较直观的。
         在看一下非零下标的dp[i]应该初始化为多少？
         在递推公式dp[i] = min(dp[i], dp[j] + 1) 中我们可以看出每次要取最小的dp[i]。
         那么非零下标的dp[i]就应该初始化为一个最大数，这样递推公式在计算结果的时候才不会被初始值覆盖！
         如果非零下标的dp[i]初始化为0，在那么在递推公式中，所有数值将都是零。
         非零下标的dp[i]初始化为一个最大数。
         */
//        Arrays.fill(f,Integer.MAX_VALUE);f[0] = 0;
        // 其实也可以这样初始化，更具dp[i]的定义，dp[i]的最大值其实就是i，也就是把每个字符分割出来。
        for(int i=0;i<s.length();i++){
            f[i]=i;
        }

        for(int i=0;i<s.length();i++){
            if(isHuiWen(s,0,i)){ // 保证了下面的 0-j 一定是
                f[i]=0;
                continue; //不需要切割寻找下一个分割点
            }

            for(int j=0;j < i;j++){
                if(isHuiWen(s,j+1,i)){
                    // 这里又忘记了一个前提 f[i]的定义应该是[0,i]的回文子串 所以无需判断
                    // isHuiWen(s,0,j); 0-j 一定保证是回文子串,代码实现时需要在前面保证这一点
                    f[i] = Math.min(f[i],f[j]+1);
                    // aab i=2 j=0,1 j+1 = 1,2 i=2
                    // 1 2 // 2 2
                }
            }
        }
        return f[s.length()-1];
    }

    public boolean isHuiWen(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}
