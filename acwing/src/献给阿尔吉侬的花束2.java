import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author Csy
 * @Classname 献给阿尔吉侬的花束2
 * @date 2022-03-25 23:01
 * @Description TODO
 */
public class 献给阿尔吉侬的花束2 {

    // 第一种解法 感觉很繁琐
    static final int N = 210;
    static int r, c;
    static int[][] dis = new int[N][N];
    static char[][] g = new char[N][N];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            r = sc.nextInt();
            c = sc.nextInt();

            for (int i = 0; i < r; i++) {
                g[i] = sc.next().toCharArray();
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (g[i][j] == 'S') {
                        P start = new P();
                        start.x = i;
                        start.y = j;
                        int d = bfs(start);
                        if (d == -1) System.out.println("oops");
                        else {
                            System.out.println(d);
                        }
                    }
                }
            }

        }
    }

    public static int bfs(P start) {
        Deque<P> q = new ArrayDeque<>();
        Arrays.stream(dis).forEach(o -> Arrays.fill(o, -1));
//        Arrays.fill(dis, -1);
        q.offerLast(start);
        dis[start.x][start.y] = 0;
        while (!q.isEmpty()) {
            P t = q.pollFirst();
            // 枚举四个相邻的格子
            for (int i = 0; i < 4; i++) {
                int a = t.x + dx[i], b = t.y + dy[i];
                // 不合法 进行下一次循环
                if (a < 0 || a >= r || b < 0 || b >= c || g[a][b] == '#') continue;
                if (dis[a][b] != -1) continue;
                dis[a][b] = dis[t.x][t.y] + 1;
                if (g[a][b] == 'E') return dis[a][b];
                P next = new P();
                next.x = a;
                next.y = b;

                q.offerLast(next);
            }
        }
        return -1;
    }

}


class P {
    int x;
    int y;
}