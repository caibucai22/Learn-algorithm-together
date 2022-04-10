import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @author Csy
 * @Classname 海港3
 * @date 2022-03-26 12:50
 * @Description TODO 滑动窗口 （最终版）
 */
public class 海港3 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 300010;
    static long[] cnt = new long[N];
    static int ret = 0;

    public static void main(String[] args) throws IOException {
        Deque<R> q = new ArrayDeque<>();
        int n = Integer.parseInt(in.readLine().split(" ")[0]);

        while (n-- > 0) {
            String[] str = in.readLine().split(" ");
            int t = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            R[] recs = new R[k];
            for (int i = 0; i < k; i++) {
                int nation = Integer.parseInt(str[i+2]);
                R rec = new R(t,nation);
                recs[i] = rec;
            }


            for(int i=0;i<k;i++){
                while(!q.isEmpty() && t - q.peekFirst().t >= 86400){
                    R r = q.pollFirst();
                    cnt[r.nation]--;
                    if(cnt[r.nation] == 0)ret--;
                }
                q.offerLast(recs[i]);
                int nation = recs[i].nation;
                if(cnt[nation] == 0)ret++;
                cnt[nation]++;
            }

            out.write(ret+"\n");
        }
        in.close();
        out.flush();
        out.close();

    }

}

class R {
    int t;
    int nation;

    public R(int t, int nation) {
        this.t = t;
        this.nation = nation;
    }
}
