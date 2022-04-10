package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Csy
 * @Classname Test迷宫种离入口最近的出口
 * @date 2022-03-27 17:28
 * @Description TODO
 */
public class Test迷宫种离入口最近的出口 {

    public static void main(String[] args) {

        char[][] g = {{'+','+','.', '+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1, 2};

        Solution1926 s = new Solution1926();
        int i = s.nearestExit(g, entrance);
        System.out.println(i);
    }

}

class Solution1926 {
    int ret = Integer.MAX_VALUE;

    public int nearestExit(char[][] maze, int[] entrance) {
        int x = entrance[0], y = entrance[1];
        bfs2(maze, x, y);
        return ret != Integer.MAX_VALUE ? ret : -1;
    }

    public void bfs(char[][] g, int x, int y) {
        Deque<Node> q = new ArrayDeque<>();
        int row = g.length, col = g[0].length;
        int[][] visited = new int[row][col];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Node start = new Node(x, y, 0);
        q.offerLast(start);

        while (!q.isEmpty()) {
            Node t = q.pollFirst();
            visited[t.x][t.y] = 1;
            if ((t.x != x || t.y != y) && (t.x == 0 || t.x == row - 1 || t.y == 0 || t.y == col - 1)) {
                ret = Math.min(ret, t.dis);
            }
            for (int i = 0; i < 4; i++) {
                int a = t.x + dx[i], b = t.y + dy[i];
                if (a >= 0 && a < row && b >= 0 && b < col && visited[a][b] == 0 && g[a][b] == '.') {
                    Node nx = new Node(a, b, t.dis + 1);
                    q.offerLast(nx);
                }
            }
        }

    }


    public void bfs2(char[][] g, int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        int row = g.length, col = g[0].length;
        int[][] dis = new int[row][col]; // 用dis来判断是否访问过
        Arrays.stream(dis).forEach(a -> Arrays.fill(a,Integer.MAX_VALUE));
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        q.offerLast(new int[]{x,y});
        dis[x][y] = 0;
        while (!q.isEmpty()) {
            int[] t = q.pollFirst();
            int tx = t[0],ty = t[1];
            if ((tx != x || ty != y) && (tx == 0 || tx == row - 1 || ty == 0 || ty == col - 1)) {
                ret = Math.min(ret, dis[tx][ty]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int a = tx + dx[i], b = ty + dy[i];
                if (a >= 0 && a < row && b >= 0 && b < col && dis[a][b] == Integer.MAX_VALUE && g[a][b] == '.') {
                    dis[a][b] = dis[tx][ty]+1;
                    q.offerLast(new int[]{a,b});
                }
            }
        }

    }

}

class Node {
    int x;
    int y;
    int dis;


    public Node(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}