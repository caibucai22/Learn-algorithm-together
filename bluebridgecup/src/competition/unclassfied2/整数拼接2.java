package competition.unclassfied2;

import java.io.*;


/**
 * @author Csy
 * @Classname 整数拼接2
 * @date 2022-03-31 22:44
 * @Description TODO
 */
public class 整数拼接2 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100010;

    public static void main(String[] args) throws IOException {
        String[] arg = in.readLine().split(" ");
        int k = Integer.parseInt(arg[1]);
        int n = Integer.parseInt(arg[0]);
        int[] a = new int[N];
        int[][] hash = new int[11][N];
        String[] s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        // 每一个数 都乘上 10^j 后取余 放入hash 存储具有相同余数的数字个数
        for (int i = 0; i < n; i++) {
            int t = a[i] % k;
            for (int j = 0; j < 11; j++) {
                hash[j][t]++;
                t = t * 10 % k;
            }
        }

        long ret = 0;

        // aj*10^len(ai)+ai %k == 0
        // aj*10^len(ai) %k == -ai%k
        // ai长度最长10位 左边部分 提前预处理出来 计算出相同余数的数量

        // 接下来就是枚举右边的 -ai%k 等价于 (k-ai)%k
        for(int i=0;i<n;i++){
            // 枚举每一个ai

            int t = a[i]%k;
            int len = String.valueOf(a[i]).length();
            ret += hash[len][(k-t)%k];

            long r = t;
            while(len-- >0)r = r*10%k;
            if(r == (k-t)%k)ret--;
        }
        System.out.println(ret);

    }

}
