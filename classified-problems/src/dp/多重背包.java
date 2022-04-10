package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Csy
 * @Classname 多重背包
 * @date 2022-03-17 11:33
 * @Description TODO
 */
public class 多重背包 {

    // 多重背包 + 二进制拆分优化

    static final int n = 1010;

    static List<Good> goods = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int w = sc.nextInt(), v = sc.nextInt(), s = sc.nextInt();
            for (int k = 1; k <= s; k *= 2) {
                s -= k;
                Good good = new Good(k * w, k * v);
                goods.add(good);
            }
            if(s > 0){
                Good good = new Good(s*w,s*v);
                goods.add(good);
            }
        }

        int[] f = new int[n];

        // list 转换为数组
//        Good[] g = (Good[]) goods.toArray(new Good[goods.size()]);
//        for (int i = 0; i < g.length; i++) {
//            // 背包容量 从大到小遍历
//            for (int j = V; j >= g[i].w; j--) {
//                f[j] = Math.max(f[j], f[j - g[i].w] + g[i].v);
//            }
//        }

        for(Good g:goods){
            for(int j=V;j>=g.w;j--){
                f[j] = Math.max(f[j],f[j-g.w]+g.v);
            }
        }
        System.out.println(f[V]);
    }
}

class Good {
    int w;
    int v;

    public Good(int w, int v) {
        this.w = w;
        this.v = v;
    }
}

