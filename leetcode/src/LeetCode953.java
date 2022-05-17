/**
 * @author Csy
 * @Classname LeetCode953
 * @date 2022-05-17 12:57
 * @Description TODO
 */
public class LeetCode953 {

    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        Solution953 s = new Solution953();
        boolean alienSorted = s.isAlienSorted(words, order);
        System.out.println(alienSorted);
    }

}


class Solution953 {
    public boolean isAlienSorted(String[] words, String order) {
        // 根据order
        // 两两比较
        int n = words.length;
        for (int i = 1; i < n; i++) {
            // for(int j=0;j<i;j++){
            boolean flag = cmp(words[i - 1], words[i], order);
            if (!flag) return false;
            // }
        }
        return true;
    }

    // 前 后 前<后
    private boolean cmp(String a, String b, String order) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            char ch1 = a.charAt(i), ch2 = b.charAt(j);
            int o1 = getOrder(ch1, order);
            int o2 = getOrder(ch2, order);
            if (o1 > o2) return false;
            else if (o1 < o2) {
                return true;
            } else {
                i++;
                j++;
            }
        }
        // 长度不一样处理判断
        if (i == a.length() && j < b.length()) return true;
        if (i < a.length() && j == b.length()) return false;
        return true;
    }

    private int getOrder(char ch, String order) {
        for (int i = 0; i < order.length(); i++) {
            if (ch == order.charAt(i)) return i;
        }
        return -1;
    }
}