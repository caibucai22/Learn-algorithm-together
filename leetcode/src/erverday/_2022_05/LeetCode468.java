package erverday._2022_05;

/**
 * @author Csy
 * @Classname LeetCode468
 * @date 2022-05-29 16:09
 * @Description TODO
 */
public class LeetCode468 {

    public static void main(String[] args) {
        Solution468 solution = new Solution468();
        String test = "256.256.256.256";
        String s = solution.validIPAddress(test);
        System.out.println(s);

    }

}

class Solution468 {
    static String[] type = {"IPv4", "IPv6", "Neither"};

    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) return checkIPv4(queryIP);
        if (queryIP.contains(":")) return checkIPv6(queryIP);
        return type[2];
    }

    private String checkIPv4(String ip) {
        String[] s = ip.split(".");
        for (String num : s) {
            int a = Integer.valueOf(num);
            System.out.println(a);
            if (a > 255 || a < 0) return type[2];
            if (count(a) < num.length()) return type[2];
        }
        return type[0];
    }

    private String checkIPv6(String ip) {
        String[] s = ip.split(":");
        for (String num : s) {
            char[] chs = num.toCharArray();
            if (chs.length > 4) return type[2];
            for (char ch : chs) {
                if (Character.isLowerCase(ch) && ch > 'f') return type[2];
            }
        }
        return type[1];
    }

    private int count(int num) {
        int cnt = 0;
        while (num != 0) {
            num /= 10;
            cnt++;
        }
        return cnt;
    }
}