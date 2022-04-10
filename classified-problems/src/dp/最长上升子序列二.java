package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Csy
 * @Classname 最长上升子序列二
 * @date 2022-03-19 10:14
 * @Description Acwing 896 数据范围 1-1e5
 *
 * 重点：维持了一个单调递增的序列 使用二分查找 得到 比nums[i] 小的最大的数
 */
public class 最长上升子序列二 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100010;

    public static void main(String[] args) throws Exception{

        // 与上升子序列 区别就是 数据更多 对上升子序列 O(n^2) 的复杂度进行优化

        int n = Integer.parseInt(in.readLine());
        int[] a = new int[N];
        String[] nums = in.readLine().split(" ");
        for(int i=1;i<=n;i++){
            a[i] = Integer.parseInt(nums[i-1]);
        }


        int q[] = new int[N];
        // 维持一个单调递增的 最后一个数最小的
        q[0] = Integer.MIN_VALUE;
        int len = 0;
        // len 是 要求的最长上升子序列长度

        for(int i=1;i<=n;i++){
            int l = 0,r = len;

            // 使用二分查找小于某个数的最大数
            while(l < r){
                // 数据 分为 小于的部分 和 大于等于的部分
                int mid = l + r + 1 >> 1;
                if(q[mid] < a[i]) l = mid;
                else r = mid - 1;
            }
            len = Math.max(len,r+1);
            q[r+1] = a[i];
        }
        out.write(len+"\n");
        in.close();
        out.flush();
        out.close();
    }
}
