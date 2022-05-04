import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Csy
 * @Classname LeetCode1832
 * @date 2022-05-04 17:06
 * @Description TODO
 */
public class LeetCode1832 {

    public static void main(String[] args) {
        int n = 5, k = 2;
        Solution1832 s = new Solution1832();
//        公式法
        int theWinner = s.findTheWinner(n, k);
        System.out.println(theWinner);

//        队列模拟
        int theWinner2 = s.findTheWinner2(n, k);
        System.out.println(theWinner2);
    }

}

class Solution1832 {
    public int findTheWinner2(int n, int k) {
        // 用队列进行模拟
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.offerLast(i);
        }
        while (!q.isEmpty()) {
            if (q.size() == 1) return q.peekFirst();
            for (int i = 1; i < k; i++) {
                Integer tmp = q.pollFirst();
                q.offerLast(tmp);
            }
            // 第k个离开
            q.pollFirst();
        }
        return -1;
    }

    public int findTheWinner(int n, int k) {
        return cir(n, k);
    }

    // 公式法 求约瑟夫环
    private int cir(int n, int k) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + k) % i;
        }
        return p + 1;
    }

}
