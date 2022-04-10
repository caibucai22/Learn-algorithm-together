package competition.sheng._2013;

/**
 * @author Csy
 * @Classname Main3
 * @date 2022-03-21 17:02
 * @Description TODO
 */
public class Main3 {

    // 振兴中华
    // 答案 35

    static int[] dx = {0,1};
    static int[] dy = {1,0};

    public static void main(String[] args) {

        // 手算
        /**
         * 1*2*2*2*2*2*1 = 32
         */

        // bfs
//        int ret = 1;
//        Deque<Point> q = new ArrayDeque<>();
//        Point s = new Point(0,0);
//        q.offerLast(s);
//        while(!q.isEmpty()){
//            int size = q.size();
//            ret += (size*size);
//            Point p = q.pollFirst();
//            if(p.x >= 0 && p.x < 5 && p.y >= 0 && p.y <4){
//                for(int i=0;i<2;i++){
//                    int a = p.x+dx[i];
//                    int b = p.y+dy[i];
//                    Point next = new Point(a,b);
//                    q.offerLast(next);
//                }
//            }
//        }
//
//        System.out.println(ret);
//        // 688731

        // dp
        // f[i,j] 表示达到i,j的方法数
        int[][] f = new int[4+1][5+1];
        for(int i=1;i<=4;i++){
            f[i][1] = 1;
        }
        for(int i=1;i<=5;i++){
            f[1][i] = 1;
        }

        for(int i=2;i<=4;i++){
            for(int j=1;j<=5;j++){
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }

        System.out.println(f[4][5]);

        // 35


    }

}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
