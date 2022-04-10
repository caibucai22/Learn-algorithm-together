package 最短路系列;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname Floyd求最短路
 * @date 2022-04-07 8:33
 * @Description TODO
 */
public class Floyd求最短路 {

    static final int N = 210, INF = (int) 1e9;
    static int[][] d = new int[N][N];

    static int n, m,q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        // init
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) d[i][j] = 0;
                else d[i][j] = INF;
            }
        }

        // construct
        for (int i = 1; i <= m; i++) {
            int a, b, w;
            a = sc.nextInt();
            b = sc.nextInt();
            w = sc.nextInt();
            d[a][b] = Math.min(d[a][b], w);
        }

        floyd();

        while(q-- > 0){
            int u = sc.nextInt(),v = sc.nextInt();
            int t = d[u][v];
            if(t > INF/2) System.out.println("impossible");
            else System.out.println(t);
        }
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }

}
