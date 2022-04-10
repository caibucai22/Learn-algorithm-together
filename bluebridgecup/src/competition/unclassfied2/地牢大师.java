package competition.unclassfied2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Csy
 * @Classname 地牢大师
 * @date 2022-03-30 18:26
 * @Description TODO AC！！！
 */
public class 地牢大师 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = 100;

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static char[][][] g;

    static int l, r, c;

    public static void main(String[] args) throws IOException {

        while (true) {
            String[] s = in.readLine().split(" ");
            l = Integer.valueOf(s[0]);
            r = Integer.valueOf(s[1]);
            c = Integer.valueOf(s[2]);

            if (l == 0 && r == 0 && c == 0) break;

            g = new char[l][r][c];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    g[i][j] = in.readLine().toCharArray();
                }
                in.readLine();
            }

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        if (g[i][j][k] == 'S') {
                            bfs(g, i, j, k);
                        }
                    }
                }
            }
        }

    }

    private static void bfs(char[][][] g, int x, int y, int z) {
        int[][][] minu = new int[l][r][c]; // 记录到达时间 + 判断是否访问
//        boolean[][][] visited = new boolean[l][r][c];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, z});

        minu[x][y][z] = 0;
        while (!q.isEmpty()) {
            int[] t = q.pollFirst();
//            visited[t[0]][t[1]][t[2]] = true;
            if(g[t[0]][t[1]][t[2]] == 'E'){
                System.out.println("Escaped in "+ minu[t[0]][t[1]][t[2]]+" minute(s).");
                return;
            }

            for (int i = 0; i < 6; i++) {
                int a = t[0] + dx[i], b = t[1] + dy[i], c2 = t[2] + dz[i];
                if(a >= 0 && a< l && b >= 0 && b< r && c2 >= 0 && c2 < c && g[a][b][c2] != '#' && minu[a][b][c2]==0){
//                    System.out.println(a+" "+b+" "+c2);
                    q.offerLast(new int[]{a,b,c2});
                    minu[a][b][c2] = minu[t[0]][t[1]][t[2]] + 1;
                }
            }
        }
        System.out.println("Trapped!");
    }

}
