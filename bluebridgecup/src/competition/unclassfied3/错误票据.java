package competition.unclassfied3;

import java.io.*;

/**
 * @author Csy
 * @Classname 错误票据
 * @date 2022-04-07 14:40
 * @Description TODO
 */
public class 错误票据 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100010;
    static int[] hash = new int[N];

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int min = Integer.MAX_VALUE, max = -1;
        while (n-- > 0) {
            s = in.readLine().trim().split(" ");
            int len = s.length;
            for (int i = 0; i < len; i++) {
                int t = Integer.parseInt(s[i]);
                min = Math.min(t, min);
                max = Math.max(t, max);
                hash[t]++;
            }
        }
        int lack = -1,repeat = -1;
        for (int i = min; i <= max; i++) {
            if(hash[i] == 0)lack = i;
            if(hash[i] > 1)repeat = i;
        }
        System.out.println(lack+" "+repeat);
    }
}
