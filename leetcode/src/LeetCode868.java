/**
 * @author Csy
 * @Classname LeetCode868
 * @date 2022-04-24 14:52
 * @Description TODO 二进制间距
 */
public class LeetCode868 {
    public static void main(String[] args) {
        int test = 22;
        Solution868 s = new Solution868();
        int i = s.binaryGap(test);
        System.out.println(i);
    }
}

class Solution868 {
    public int binaryGap(int n) {
        int ret = 0;
        int cur = 0, last = -1;
        for (int i = 0; i < 32; i++) {
            // 右移
            if (((n >> i) & 1) != 0) {
                // 加个特判 第一次出现
                if (last == -1) {
                    last = i;
                    cur = i;
                } else {
                    last = cur;
                    cur = i;
                    ret = Math.max(ret, cur - last);
                }
                // 1100
                // last 3 3
                // cur  3 4
            }
        }
        return ret;
    }
}