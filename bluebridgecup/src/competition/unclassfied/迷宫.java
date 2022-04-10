package competition.unclassfied;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Csy
 * @Classname 迷宫
 * @date 2022-03-24 15:51
 * @Description TODO
 */
public class 迷宫 {

    static final int N = 35, M = 55;
    static final int n = 30, m = 50;
    static char[][] g = new char[N][M];

    static String path = "";
    static List<String> list = new ArrayList<>();


    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};

    public static void main(String[] args) {
        try {
            init();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 50; j++) {
//                System.out.printf("%c",g[i][j]);
            }
//            System.out.println();
        }

        dfs1(0, 0, g);


        if (list.size() > 0) {
            System.out.println(list.get(0));
        }

    }

    private static void dfs1(int x, int y, char[][] map) {
        if (x < 0 || x >= n || y < 0 || y >= m || map[x][y] == '1') {
            return;
        }
        if (x == n - 1 && y == m - 1) {
            list.add(path);
            return;
        }

        String t = path;
        map[x][y] = '1';

        for (int i = 0; i < 4; i++) {

            if (dx[i] == 0 && dy[i] == -1) path = path + "D";
            if (dx[i] == -1 && dy[i] == 0) path = path + "L";
            if (dx[i] == 1 && dy[i] == 0) path = path + "R";
            if (dx[i] == 0 && dy[i] == 1) path = path + "U";

            int a = x + dx[i], b = y + dy[i];
            dfs1(a, b, map);

        }

        //recover
        map[x][y] = '0';
        path = t;


    }


    private static void init() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(new File("C:\\Users\\Csy\\IdeaProjects\\algorithm-course\\bluebridgecup\\src\\competition\\unclassfied\\maze")));
        int i = 0;
        while (sc.hasNext()) {
            String str = sc.next();
            g[i++] = str.toCharArray();
        }
    }

}
