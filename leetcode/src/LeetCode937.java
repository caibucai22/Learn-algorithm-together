import java.util.*;

/**
 * @author Csy
 * @Classname LeetCode937
 * @date 2022-05-03 13:01
 * @Description TODO
 */
public class LeetCode937 {

    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        Solution937 s = new Solution937();
        s.reorderLogFiles(logs);
        Arrays.stream(logs).forEach(o -> System.out.println(o));
    }

}

class Solution937 {
    public String[] reorderLogFiles(String[] logs) {
        // 截取出 除标识符以为的内容
        List<String> letLog = new ArrayList<>();
        List<String> digLog = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        for (String s : logs) {
            int idx = s.indexOf(' ');
            String content = s.substring(idx);
            if (isDigLog(content)) {
                digLog.add(s);
            } else {
                letLog.add(s);
            }
        }

        Collections.sort(letLog, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int idx1 = o1.indexOf(' ');
                int idx2 = o2.indexOf(' ');
                String m1 = o1.substring(0, idx1);
                String m2 = o2.substring(0, idx2);
                String s1 = o1.substring(idx1);
                String s2 = o2.substring(idx2);
//                System.out.println(m1 + " " + s1);
//                System.out.println(m2 + " " + s2);
                if (s1.equals(s2)) {
                    return m1.compareTo(m2);
                } else {
                    return s1.compareTo(s2);
                }
            }
        });

        for (int i = 0; i < letLog.size(); i++) {
            ret.add(letLog.get(i));
        }

        for (int i = 0; i < digLog.size(); i++) {
            ret.add(digLog.get(i));
        }

        return ret.toArray(new String[ret.size()]);
    }

    private boolean isDigLog(String s) {
        for (char ch : s.toCharArray()) {
            if (ch == ' ') continue;
            if (!(ch >= '0' && ch <= '9')) return false;
        }
        return true;
    }
}