import java.util.Scanner;

/**
 * @author Csy
 * @Classname 摘花生
 * @date 2022-03-31 8:57
 * @Description TODO
 */
public class 摘花生 {

    static final int N = 110;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[][] f = new int[N][N];
        while(T -- >0){
            int r = sc.nextInt(),c = sc.nextInt();
            for(int i=1;i<=r;i++){
                for(int j=1;j<=c;j++){
                    f[i][j] = sc.nextInt();
                }
            }

            // 向下或向右走
            for(int i=1;i<=r;i++){
                f[i][1] += f[i-1][1];
            }
            for(int j=1;j<=c;j++){
                f[1][j] += f[1][j-1];
            }

            for(int i=2;i<=r;i++){
                for(int j=2;j<=c;j++){
                    f[i][j] += Math.max(f[i-1][j],f[i][j-1]);
                }
            }
            System.out.println(f[r][c]);
        }
    }

}
