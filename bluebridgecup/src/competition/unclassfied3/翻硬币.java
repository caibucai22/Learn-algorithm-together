package competition.unclassfied3;

import java.io.*;

/**
 * @author Csy
 * @Classname 翻硬币
 * @date 2022-04-07 14:56
 * @Description TODO
 */
public class 翻硬币 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String start = in.readLine();
        String end = in.readLine();
        int n = start.length();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = start.charAt(i) == 'o' ? 0 : 1;
            b[i] = end.charAt(i) == 'o' ? 0 : 1;
        }
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != b[i]) {
                a[i] ^= 1;
                a[i + 1] ^= 1;
                cnt++;
            }
        }
        System.out.println(cnt);


    }

}
