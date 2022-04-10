package competition.unclassfied;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 全球变暖
 * @date 2022-03-24 16:24
 * @Description TODO
 */
public class 全球变暖 {

    static int N;
    static char[][] g;

    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};

    static boolean[][] visited;

    static int total = 0, edge = 0;

    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        g = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            g[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (g[i][j] == '#' && !visited[i][j]) {
                    total = 0;
                    edge = 0;
                    dfs2(i, j, g);
                    if (total == edge) ret++;
                }

            }
        }


        System.out.println(ret);
    }

    private static void dfs1(int x, int y, char[][] g) {

        total++; // 统计岛的所有格子数

        if (hasWater(x, y, g)) edge++; // 统计边缘格子数

        visited[x][y] = true;


        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < N && b >= 0 && b < N && g[a][b] == '#' && !visited[a][b]) {
                dfs1(a, b, g);
            }

        }


    }

    // 检查周边是否有 水
    private static boolean hasWater(int x, int y, char[][] g) {
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < N && b >= 0 && b < N) {
                if (g[a][b] == '.') return true;
            }

        }
        return false;
    }



    public static void dfs2(int x,int y,char[][] g){
        if(g[x][y] != '#')return;
        if(x<0 || x>=N ||y<0 || y>=N)return;

        visited[x][y] = true;
        total++;
        if(hasWater(x,y,g))edge++;

        for(int i=0;i<4;i++){
            int a = x+dx[i],b=y+dy[i];
            if(!visited[a][b])dfs2(a,b,g);
        }

    }

}

