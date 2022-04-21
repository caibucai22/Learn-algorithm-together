/**
 * @author Csy
 * @Classname LeetCode824
 * @date 2022-04-21 16:31
 * @Description TODO
 */
public class LeetCode824 {

    public static void main(String[] args) {
        String test = "The quick brown fox jumped over the lazy dog";
        Solution824 s = new Solution824();
        String goatLatin = s.toGoatLatin(test);
        System.out.println(goatLatin);
    }
}

class Solution824 {
    public String toGoatLatin(String sentence) {
        String[] s = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            char ch = s[i].charAt(0);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                sb.append(s[i]).append("ma");
            } else {
                s[i] = s[i].substring(1) + s[i].substring(0, 1);
                sb.append(s[i]).append("ma");
            }

            for (int cnt = 0; cnt < i + 1; cnt++) sb.append('a');
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
