import java.util.*;

/**
 * @author Csy
 * @Classname LeetCode819
 * @date 2022-04-17 22:02
 * @Description TODO
 */
public class LeetCode819 {

    public static void main(String[] args) {
        String test ="Bob. hIt, baLl";
        String[] ban = {"bob","hit"};

        Solution819 s = new Solution819();
        String s1 = s.mostCommonWord(test, ban);
        System.out.println(s1);
    }
}


class Solution819 {

//    public String mostCommonWord1(String paragraph, String[] banned) {
//        Set<String> ban = new HashSet<>(Arrays.asList(banned));
//        // Collections.addAll(banned);
//        HashMap<String, Integer> map = new HashMap<>();
//        String s = "";
//        paragraph = paragraph.toLowerCase() + " ";
//        int n = paragraph.length();
//        for (int i = 0; i < n; i++) {
//            char ch = paragraph.charAt(i);
//            if (ch == ' ' || ch == ',' || ch == '?' || ch == '.' || ch == '!' || ch == ';') {
//                if (ban.contains(s)) {
//                    s = "";
//                    continue;
//                }
//                if("".equals(s))continue;
//                map.put(s, map.getOrDefault(s, 0) + 1);
//                s = "";
//                continue; // 清空s后 不执行下面拼接逻辑
//            }
//            s = s + ch;
//        }
//        if (Character.isLetterOrDigit(paragraph.charAt(n - 1))) {
//            map.put(s, map.getOrDefault(s, 0) + 1);
//        }
//
//        return map.entrySet().stream().max((o1, o2) -> o1.getValue() - o2.getValue()).get().getKey();
//    }

    public String mostCommonWord(String s, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String b : banned) set.add(b);
        char[] cs = s.toCharArray();
        int n = cs.length;
        String ans = null;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ) {
            if (!Character.isLetter(cs[i]) && ++i >= 0) continue;
            int j = i;
            while (j < n && Character.isLetter(cs[j])) j++;
            String sub = s.substring(i, j).toLowerCase();
            i = j + 1;
            if (set.contains(sub)) continue;
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (ans == null || map.get(sub) > map.get(ans)) ans = sub;
        }
        return ans;
    }
}