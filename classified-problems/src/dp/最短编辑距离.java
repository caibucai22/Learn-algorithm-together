package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Csy
 * @Classname 最短编辑距离
 * @date 2022-03-19 12:47
 * @Description TODO
 */
public class 最短编辑距离 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 1010;

    public static void main(String[] args) throws Exception {
        String[] nums1 = in.readLine().split(" ");
        int n = Integer.parseInt(nums1[0]);
        String a = in.readLine();
        String[] nums2 = in.readLine().split(" ");
        int m = Integer.parseInt(nums2[0]);
        String b = in.readLine();

        int[][] f = new int[N][N];

        for (int i = 0; i <= n; i++) f[i][0] = i;
        for (int j = 0; j <= m; j++) f[0][j] = j;


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.min(f[i-1][j]+1,f[i][j-1]+1);
                if(a.charAt(i-1) == b.charAt(j-1)){
                    f[i][j] = Math.min(f[i][j],f[i-1][j-1]);
                }else{
                    f[i][j] = Math.min(f[i][j],f[i-1][j-1]+1);
                }
            }
        }

        out.write(f[n][m]+"\n");

        in.close();
        out.flush();
        out.close();
    }

}
