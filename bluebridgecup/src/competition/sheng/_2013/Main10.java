package competition.sheng._2013;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Csy
 * @Classname Main10
 * @date 2022-03-21 20:32
 * @Description TODO
 */
public class Main10 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = 50010;
    public static void main(String[] args) throws IOException {
        // 全排列，
        // 是找 序列中连续上升子串的个数

        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        int[] nums = new int[s.length];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        // 连续单调队列 两个 枚举入队起始位置 只有两个元素不连续就停止
        // 枚举下一个位置
        // 1 2 3 4
        // 4 3 2

        // 队尾元素是最大的
        //

        Deque<Integer> up = new ArrayDeque<>();
        Deque<Integer> t = new ArrayDeque<>();
        int ret = 0;
        for(int i=0;i<n;i++){
            up.offerLast(nums[i]);
            ret++;
            int j = i+1;
            while(j < n && !up.isEmpty() && up.peekLast()+1 == nums[j] ){
                up.offerLast(nums[j]);
                j++;
                ret++;
            }
            int k = j;
            while(k < n && !up.isEmpty() && up.peekLast() == nums[k]+1){
                t.offerLast(up.pollFirst());
            }
            up.offerLast(nums[k]);

            // 返回


        }




    }

}
