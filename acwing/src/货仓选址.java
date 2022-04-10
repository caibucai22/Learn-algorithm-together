import java.io.*;
import java.util.Arrays;

/**
 * @author Csy
 * @Classname 货仓选址
 * @date 2022-04-05 18:08
 * @Description TODO
 */
public class 货仓选址 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100010;

    public static void main(String[] args) throws IOException {

        int[] a = new int[N];
        int n = Integer.parseInt(in.readLine().split(" ")[0]);
        String[] s = in.readLine().split(" ");
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(a,0,n);
        int idx = a[n/2];
        long ret = 0;
        for(int i=0;i<n;i++)ret += Math.abs(a[i]-idx);

        out.write(String.valueOf(ret));

        in.close();
        out.flush();
        out.close();
    }

}
