package leetcode;

/**
 * @author Csy
 * @Classname Test排列硬币
 * @date 2022-04-03 10:20
 * @Description TODO
 */
public class Test排列硬币 {

    public static void main(String[] args) {

        Solution441 s = new Solution441();
        int i = s.arrangeCoins(1804289383);
        System.out.println(i);
    }
}

class Solution441 {

    public int arrangeCoins(int n){
        // a[i] != i;
        // 数学公式 0.5x^2 + 0.5 x x从1是单调递增的
        int l = 0,r = n;
        while(l < r){
            int mid = l + (r-l>>1);
            // 找第一个 < n 的最大数
//            double sum = 0.5*(mid*mid + mid);
//            if( sum >= n)r = mid;
            if(mid+1 >= 2*(n/mid))r = mid;
            else{
                // t < n
                l = mid+1;
            }
        }
        double t = 0.5*(l*l+l);
        double t2 = 0.5*l*(l+1);
        System.out.println("t2 = "+t + "n = "+n);
        System.out.println("行数求和是否大于总数："  + (t2 > n));
        return t <= n ? l:l-1;
    }

    // 数学计算
    public int arrangeCoins2(int n){
        for(int i=1;i<=(int)Math.sqrt(n);i++){
            // if(i*(i+1)/2)
        }
        return -1;
    }

    // 暴力相加
    public int arrangeCoins1(int n) {
        // 直接加就行，直到》=n退出
        long sum = 0;
        for(long i=1;i<=n;i++){
            sum += i;
            if(sum==n){
                return (int)i;
            }else if(sum>n){
                return (int)(i-1);
            }
        }
        return 0;

        // 2147483647 未通过


    }
}
