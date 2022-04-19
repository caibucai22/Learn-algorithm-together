import java.util.Arrays;

/**
 * @author Csy
 * @Classname LeetCode821
 * @date 2022-04-19 13:28
 * @Description TODO
 */
public class LeetCode821 {

    public static void main(String[] args) {

    }
}

class Solution821 {
    public int[] shortestToChar(String s, char c) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        int[] ret = new int[n];
        Arrays.fill(ret, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int l = i, r = i + 1;
            while (l < r) {
                while (l > 0 && chs[l] != c) l--;
                while (r < n && chs[r] != c) r++;
                break;
            }
            if (chs[l] == c) ret[i] = Math.min(ret[i], i - l);
            if (r != n && chs[r] == c) ret[i] = Math.min(ret[i], r - i);
        }
        return ret;
    }
}
