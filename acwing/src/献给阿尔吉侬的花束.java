import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author Csy
 * @Classname 献给阿尔吉侬的花束
 * @date 2022-03-25 22:34
 * @Description TODO
 */
public class 献给阿尔吉侬的花束 {

    //

    static boolean[][] v;
    static Point[][] g;
    static int ret = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt(), c = sc.nextInt();

            g = new Point[r][c];
            v = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                char[] chs = sc.next().toCharArray();
                for (int j = 0; j < c; j++) {
                    Point p = new Point();
                    p.x = i;
                    p.y = j;
                    p.v = chs[j];
                    g[i][j] = p;
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (g[i][j].v == 'S') {
                        int dis = bfs(g[i][j]);
                        if (dis > 0) System.out.println(dis);
                        else if (dis == -1) {
                            System.out.println("oop!");
                        }
                    }
                }
            }
        }
    }

    public static int bfs(Point p) {
        Deque<Point> q = new ArrayDeque<>();
        q.offerLast(p);

        // 全局变量 每次bfs清0
        ret = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            ret++;
            for(int j = 0;j<size;j++){ // 这样做 每一层全部出队，不是一次while循环出去一个，理解起来更好
                Point cur = q.pollFirst();
                if (cur.v == 'E') {
                    return cur.dis;
                }
                for (int i = 0; i < 4; i++) {
                    int a = cur.x + dx[i], b = cur.y + dy[i];

                    // 合法才加入
                    if (a >= 0 && a < g.length && b >= 0 && b < g[0].length && !v[a][b] && g[a][b].v != '#') {
                        v[a][b] = true;
                        g[a][b].dis = ret;
                        q.offerLast(g[a][b]);
                    }

                }
            }

        }
        return -1;
    }
}

class Point {
    int x;
    int y;
    char v;
    int dis;
}
