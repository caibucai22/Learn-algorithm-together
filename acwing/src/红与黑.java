import java.io.*;

/**
 * @author Csy
 * @Classname 红与黑
 * @date 2022-03-29 21:42
 * @Description TODO dfs flood fill
 */
public class 红与黑 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int w;
    static int h;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int ret = 0;

    public static void main(String[] args) throws IOException {


        while (true) {
            ret = 0;
            String[] a = in.readLine().split(" ");
            w = Integer.parseInt(a[0]);
            h = Integer.parseInt(a[1]);
            if (w == 0 && h == 0) break;
            char[][] g = new char[h][];
            for (int i = 0; i < h; i++) {
                g[i] = in.readLine().toCharArray();
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (g[i][j] == '@') {
                        dfs(g, i, j);
                    }
                }
            }

            System.out.println(ret);
        }

    }

    private static void dfs(char[][] g, int x, int y) {
        ret++;
        g[x][y] = '#';
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < h && b >= 0 && b < w && g[a][b] != '#') {
                dfs(g, a, b);
            }
        }
    }

}
