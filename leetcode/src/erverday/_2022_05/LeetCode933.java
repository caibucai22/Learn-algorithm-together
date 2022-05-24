package erverday._2022_05;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Csy
 * @Classname erverday._2022_05.LeetCode933
 * @date 2022-05-06 14:06
 * @Description TODO 最近的请求次数
 */
public class LeetCode933 {

    public static void main(String[] args) {

    }

}


class RecentCounter {

    private int cnt;
    private Deque<Integer> q;
    public RecentCounter() {
        this.cnt = 0;
        this.q = new ArrayDeque<>();
    }

    public int ping(int t) {
        while(!q.isEmpty()){
            int time = q.peekFirst();
            if(time < t-3000){
                q.pollFirst();
            }else{
                break;
            }
        }
        q.offerLast(t);
        return q.size();
    }
}
