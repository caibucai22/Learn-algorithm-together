package competition.unclassfied2;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Csy
 * @Classname 整数拼接
 * @date 2022-03-31 16:52
 * @Description TODO n^2 的规模 肯定超时 可以使用一下记忆化搜索 预存
 */
public class 整数拼接 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100010;
    static boolean[] used;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        int[] a = new int[N];
        used = new boolean[N];
        String[] arg = in.readLine().split(" ");
        int k = Integer.parseInt(arg[1]);
        int n = Integer.parseInt(arg[0]);
        String[] s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        dfs(a, new ArrayList<>(),n,k);

        out.write(cnt);
        System.out.println(cnt);
        in.close();
        out.flush();
        out.close();
    }

    private static void dfs(int[] a, List<Integer> path, int n,int k) {
        if (path.size() == 2) {
            String num = path.get(0) +""+ path.get(1) ;
            BigDecimal t = new BigDecimal(num);
            BigDecimal[] ret = t.divideAndRemainder(BigDecimal.valueOf(k));
            if (ret[1] == BigDecimal.ZERO) cnt++;
            return;
        }

        for(int i=0;i<n;i++){
            if(!used[i]){
                path.add(a[i]);
                used[i] = true;
                dfs(a,path,n,k);
                used[i] = false;
                path.remove(path.size()-1);
            }

        }
    }

}
