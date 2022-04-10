import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Csy
 * @Classname 海港2
 * @date 2022-03-26 12:02
 * @Description TODO
 * <p>
 * 刚开始没审清题意，以为每一个游客下船的时间也算一秒，实际上以船到达的时间作为游客到达的时间
 * <p>
 * 题目保证船到达的时间单调递增，保证了单调队列
 */
public class 海港2 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 300010;
    static long[] cnt = new long[N];
    static int ret = 0;

    public static void main(String[] args) throws IOException {

        Deque<Integer> q = new ArrayDeque<>();
        int n = Integer.parseInt(in.readLine().split(" ")[0]);


        for (int i = 0; i < n; i++) {
            String[] s = in.readLine().split(" ");

            int t = Integer.parseInt(s[0]); // 船到达的时间
            int k = Integer.parseInt(s[1]);

            int[] nation = new int[k];
            for (int j = 0; j < k; j++) {
                nation[j] = Integer.parseInt(s[j + 2]);
            }


            for (int j = 0; j < k; j++) {

                // 超出窗口大小 队首出队
                while (q.size() > 0 && t - q.peekFirst() >= 86400) {
                    // 这里写的有问题  应当是对首出队，然后那个国家--，这里没有保存国家信息，减错了
                    int c = nation[j];
                    cnt[c]--;
                    if (cnt[c] == 0) ret--;
                    q.pollFirst();

                }

                q.offerLast(t); // 这里面t这个时间被多次入队，但是没有影响，

                if (cnt[nation[j]] == 0) ret++;
                cnt[nation[j]]++;

            }

            out.write(ret + "\n");
        }

        in.close();
        out.flush();
        out.close();
    }

}
