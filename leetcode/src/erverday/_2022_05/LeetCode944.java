package erverday._2022_05;

/**
 * @author Csy
 * @Classname erverday._2022_05.LeetCode944
 * @date 2022-05-12 12:43
 * @Description TODO
 */
public class LeetCode944 {
    public static void main(String[] args) {
        String[] strs = {"rrjk", "furt", "guzm"};
        Solution944 s = new Solution944();
        int i = s.minDeletionSize(strs);
        System.out.println(i);
    }
}

class Solution944 {
    public int minDeletionSize(String[] strs) {
        int ret = 0;
        int n = strs.length;
        int len = strs[0].length();

        for (int i = 0; i < len; i++) { // 第i个字符
            for (int j = 1; j < n; j++) { // 第 j 个字符串
                char a = strs[j - 1].charAt(i);
                char b = strs[j].charAt(i);
                if (b < a) {
                    ret++;
                    break;
                }
            }
        }
        return ret;
    }
}
