package competition.unclassfied3;

import java.io.*;

/**
 * @author Csy
 * @Classname K倍区间
 * @date 2022-03-31 23:22
 * @Description TODO
 */
public class K倍区间 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N = 100010;

    public static void main(String[] args) throws IOException {

        String[] arg = in.readLine().split(" ");
        int n = Integer.parseInt(arg[0]);
        int k = Integer.parseInt(arg[1]);


        long[] s = new long[N]; // 防止爆int 使用long[]
        long[] cnt = new long[N]; // 因为k是1-100000 所以空间也要开N那么大

        for(int i=1;i<=n;i++){
            int a = Integer.parseInt(in.readLine().split(" ")[0]);
            s[i] = s[i-1] + a;
        }

        long ret = 0;
        cnt[0] = 1;

        for(int r=1;r<=n;r++){
            ret += cnt[(int) (s[r]%k)]; // 这里是先加区间数
            // 理解是这个点与前面余数相同的点 形成的区间个数 所以ret+= 在前

            cnt[(int) (s[r]%k)]++;// 然后更新
        }

        System.out.println(ret);
    }

}
