package competition.sheng._2021;

/**
 * @author Csy
 * @Classname SolutionA
 * @date 2022-01-23 9:57
 * @Description TODO
 */
public class 路径2 {

    // 路径

    static final int N = 2050;

    public static void main(String[] args) {
        // 建图
        int[][] g = new int[N][N];

        for (int i = 1; i <= 2021; i++) {
            for (int j = 1; j <= i + 21; j++) { // j <= i+21  j<=2021
                if (Math.abs(i - j) <= 21) {
                    g[i][j] = lcm(j, i);
//                    g[j][i] = lcm(i,j); 不需要对称，单源最短路径
                }
            }
        }

        boolean[] visited = new boolean[N]; // 是否已经求得了最短路径
        int[] dis = new int[N];
        for (int i = 1; i <= 2021; i++) dis[i] = g[1][i];


        int min, minIdx = 0;
        while (!visited[2021]) {
            min = Integer.MAX_VALUE;
            for (int i = 2; i <= 2021; i++) {
                if (!visited[i] && dis[i] != 0 && dis[i] < min) {
                    min = dis[i];
                    minIdx = i;
                }
            }
            visited[minIdx] = true;

            for (int i = minIdx + 1; i <= minIdx + 21; i++) {
                if(g[minIdx][i] != 0){
                    if(dis[i] == 0 )dis[i] = dis[minIdx] +g[minIdx][i];
                    else{
                        if(dis[minIdx]+g[minIdx][i]<dis[i]){
                            dis[i] = dis[minIdx]+g[minIdx][i];
                        }
                    }
                }
            }
        }
        System.out.println(dis[2021]);
    }


    // 最小公倍数
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


    // 最大公倍数
    static int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

}
