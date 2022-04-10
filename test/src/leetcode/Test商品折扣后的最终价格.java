package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Csy
 * @Classname Test商品折扣后的最终价格
 * @date 2022-03-31 15:42
 * @Description TODO
 */
public class Test商品折扣后的最终价格 {

    public static void main(String[] args) {
        Solution1475 s = new Solution1475();
        int[] a = {1,7,7,10,1};
        s.finalPrices(a);
    }

}

class Solution1475 {
    public int[] finalPrices(int[] prices) {
        // 下一个小于price[i] 的数
        int n = prices.length;
        int[] ret = new int[n];
        System.arraycopy(prices,0,ret,0,n);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]){
                ret[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return ret;
    }
}
