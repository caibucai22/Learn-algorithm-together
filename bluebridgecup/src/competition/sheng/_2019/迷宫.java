package competition.sheng._2019;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author Csy
 * @Classname 迷宫
 * @date 2022-03-27 14:56
 * @Description TODO BFS 可以用来求最短路
 */
public class 迷宫 {


    static int step = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\Csy\\IdeaProjects\\algorithm-course\\bluebridgecup\\src\\competition\\_2019\\maze"));
        char[][] g = new char[30][50];
//        visited = new boolean[30][50];
        int idx = 0;
        while (sc.hasNext()) {
            g[idx++] = sc.next().toCharArray();
        }

//        for(int i=0;i<30;i++){
//            for(int j=0;j<50;j++){
//                System.out.printf("%c",g[i][j]);
//            }
//            System.out.println();
//        }
        // D L R U 下 左 右 上

        String bfs = bfs2(g,30, 50);
        System.out.println(bfs);
//        System.out.println(step);
    }


//    public static String bfs(int row, int col) {
//        StringBuilder ret = new StringBuilder();
//
//        Deque<Point> q = new ArrayDeque<>();
//        Deque<Point> stack = new ArrayDeque<>();
//        int[] dx = {0, -1, 1, 0};
//        int[] dy = {1, 0, 0, -1};
//        String[] dir = {"R", "U", "D", "L"};
//
//        Point p = new Point(0, 0);
//        q.offerLast(p);
//        visited[0][0] = true;
//        while (!q.isEmpty()) {
//            step++;
//            int size = q.size();
//            for (int i = 0; i < size; i++) { // 以层的形式 整体向前推进
//                Point f = q.pollFirst();
//                stack.offerLast(f);// 记录路径
//                visited[f.x][f.y] = true; // 出队时设为访问过
//
//
//                for (int j = 0; j < 4; j++) {
//                    int a = f.x + dx[j], b = f.y + dy[j];
//                    String d = dir[j];
//
//                    // exit
//                    if (a == row - 1 && b == col - 1 && !visited[a][b] && g[a][b] == '0') {
//                        //print
//                        Point cur = stack.pollLast();
//                        ret.append(cur.d);
//                        int preX = cur.preX, preY = cur.preY;
//                        while (!stack.isEmpty()) {
//                            cur = stack.pollLast();
//                            if (preX == cur.x && preY == cur.y) {
//                                if (cur.d != null) ret.append(cur.d);
//                                preX = cur.x;
//                                preY = cur.y;
//                            }
//                        }
//                        return ret.reverse().toString();
//                    }
//
//
//                    if (a >= 0 && a < 30 && b >= 0 && b < 50 && g[a][b] != '1' && !visited[a][b]) {
//                        Point nx = new Point(a, b);
//                        nx.step = step;
//                        nx.preX = f.x;
//                        nx.preY = f.y;
//                        nx.d = d;
////                        nx.step = f.step+1;
////                        visited[a][b]= true;
//
//                        q.offerLast(nx);
//                    }
//                }
//            }
//        }
//        return null;
//    }

    public static String bfs2(char[][] g,int row, int col) {
        int[] dx = {-1,0,0,1};
        int[] dy = {0,1,-1,0};
        String[] direction = {"U", "R", "L", "D"};
        int[][] visited = new int[row][col];
        Queue<Point> queue = new LinkedList<>();
        Stack<Point> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        Point p = new Point(0, 0, -1, -1, 0, null);
        queue.offer(p);
        while (!queue.isEmpty()) {

            Point head = queue.poll();
            stack.push(head);
            visited[head.x][head.y] = 1;
            for(int i=0;i<4;i++){
                int x = head.x+dx[i];
                int y= head.y+dy[i];
                String d = direction[i];

                if(x == row-1 && y==col-1 && g[x][y]=='0' && visited[x][y]==0){
                    sb.append(d);
                    Point last = stack.pop();
                    sb.append(last.d);
                    int preX = last.preX;
                    int preY = last.preY;
                    while(!stack.isEmpty()){
                        last = stack.pop();
                        if(last.x == preX && last.y == preY){
                            if(last.d != null){
                                sb.append(last.d);
                            }
                            preX = last.preX;
                            preY = last.preY;
                        }
                    }
                    return sb.reverse().toString();
                }

                if(x>=0 && x< row && y>=0 && y<col && visited[x][y]==0 && g[x][y] == '0'){
                    Point nx = new Point(x,y,head.x,head.y,head.step+1,d);
                    queue.offer(nx);
                }
            }

//            Point f = queue.poll();
//            stack.push(f);// 记录路径
//            visited[f.x][f.y] = true; // 出队时设为访问过
//
//            for (int j = 0; j < 4; j++) {
//                int a = f.x + dx[j], b = f.y + dy[j];
//                String d = dir[j];
//
//                // exit
//                if (a == row - 1 && b == col - 1 && !visited[a][b] && g[a][b] == '0') {
//                    //print
//                    Point cur = stack.peek();
//                    stack.pop();
//
//                    ret.append(d); // 记录最后一步
//                    ret.append(cur.d); // 记录倒数第二步
//
//                    int preX = cur.preX, preY = cur.preY;
//
//                    while (!stack.isEmpty()) {
//                        cur = stack.pop();
//                        if (preX == cur.x && preY == cur.y) {
//                            if (cur.d != null){
//                                ret.append(cur.d);
//                            }
//                            preX = cur.x;
//                            preY = cur.y;
//                        }
//                    }
//                    return ret.reverse().toString();
//                }
//
//
//                //bfs
//                if (a >= 0 && a < row && b >= 0 && b < col && g[a][b] != '1' && !visited[a][b]) {
//                    Point nx = new Point(a, b,f.x,f.y,f.step+1,d);
//                    queue.offer(nx);
//                }
//            }
        }

        return null;
    }

}

class Point {
    int x;
    int y;
    int preX;
    int preY;
    int step;
    String d;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int preX, int preY, int step, String d) {
        this.x = x;
        this.y = y;
        this.preX = preX;
        this.preY = preY;
        this.step = step;
        this.d = d;
    }
}
