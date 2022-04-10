import java.io.*;

/**
 * @author Csy
 * @Classname 字符串价值
 * @date 2022-04-02 19:05
 * @Description TODO
 */
public class 字符串价值 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        int[] v = new int[4];
        for(int i=0;i<4;i++){
            v[i] = Integer.parseInt(s[i]);
        }

        String str = in.readLine();
        char[] chs = str.toCharArray();

        int sum = 0;
        for(int i=0;i<chs.length;i++){
            int idx = chs[i]-'1';
            sum += v[idx];
        }
        out.write(sum);
        in.close();
        out.flush();
        out.close();

    }

}
