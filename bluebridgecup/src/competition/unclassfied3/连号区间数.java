package competition.unclassfied3;

import java.io.*;

/**
 * @author Csy
 * @Classname 连号区间数
 * @date 2022-04-07 15:12
 * @Description TODO
 */
public class 连号区间数 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);

        s = in.readLine().trim().split(" ");
        int len = s.length;
        int[] a = new int[len];
        for(int i=0;i<len;i++)a[i] = Integer.parseInt(s[i]);

        int cnt = 0;
        for(int i=0;i<len;i++){
            int min = Integer.MAX_VALUE,max = -1;
            for(int j=i;j<len;j++){
                min = Math.min(min,a[j]);
                max = Math.max(max,a[j]);
                if(max - min == j-i+1)cnt++;
            }
        }
        System.out.println(cnt);
    }

}
