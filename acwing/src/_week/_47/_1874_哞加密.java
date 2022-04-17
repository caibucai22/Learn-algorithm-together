package _week._47;

import java.util.*;

/**
 * @author Csy
 * @Classname _1874_哞加密
 * @date 2022-04-17 22:48
 * @Description TODO
 */

public class _1874_哞加密 {
    static int N = 60;
    static int n, m;
    static Map<String, Integer> map = new HashMap<>();
    static char[][] g = new char[N][N];
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void getnum(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int a1 = x + dx[i];
            int b1 = y + dy[i];
            int a2 = a1 + dx[i];
            int b2 = b1 + dy[i];
            if (a1 >= 0 && a1 < n && b1 >= 0 && b1 < m && a2 >= 0 && a2 < n && b2 >= 0 && b2 < m) {
                if (g[a1][b1] == g[a2][b2] && g[a1][b1] != g[x][y]) {
                    String s = "";
                    s += g[x][y];
                    s += g[a1][b1];
                    if (map.get(s) == null) map.put(s, 1);
                    else map.put(s, map.get(s) + 1);

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scan.next();
            for (int j = 0; j < m; j++) {
                g[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                getnum(i, j);
            }
        }

        int res = 0;
        for (String key : map.keySet()) {
            if (key.charAt(1) == 'O') {
                continue;
            }
            res = Math.max(res, map.get(key));
        }
        System.out.println(res);
    }
}
//
//作者：栗子ing
//        链接：https://www.acwing.com/solution/content/111142/
//        来源：AcWing
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。