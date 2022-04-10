/**
 * @author Csy
 * @Classname 滑动窗口
 * @date 2022-03-26 10:20
 * @Description TODO
 */

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 滑动窗口 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] arg = in.readLine().split(" ");
        int n = Integer.parseInt(arg[0]), k = Integer.parseInt(arg[1]);
        int[] a = new int[n];
        String[] nums = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(nums[i]);
        }
        Deque<Integer> q = new ArrayDeque<>();

        // 最小值
        for (int i = 0; i < n; i++) {
            // 维持单调递减队列 队首就是最大值
            // 维持单调递增队列 队首一定是最小值

            while (q.size() > 0 && a[q.peekLast()] >= a[i]) q.pollLast();

            q.offerLast(i);

            // 如果窗口大小超过 k 队首出队)
            // if(q.peekFirst() < i-k+1)
            if (i - q.peekFirst() + 1 > k) q.pollFirst();

            // 窗口形成后 即可输出最大值
            if (i - k + 1 >= 0) out.write(a[q.peekFirst()] + " ");
        }
        out.write("\n");
        // 清空队列后使用
        while (!q.isEmpty()) q.pollFirst();

        // 最大值
        for (int i = 0; i < n; i++) {
            // 维持单调递减队列 队首就是最大值
            // 维持单调递增队列 队尾不一定是最大值？？？

            while (q.size() > 0 && a[q.peekLast()] <= a[i]) q.pollLast();

            q.offerLast(i);


            if (i - q.peekFirst() + 1 > k) q.pollFirst();


            if (i - k + 1 >= 0) out.write(a[q.peekFirst()] + " ");
        }


        in.close();
        out.flush();
        out.close();
    }

}
