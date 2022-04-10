package competition.sheng._2014;

/**
 * @author Csy
 * @Classname Main6
 * @date 2022-03-22 18:27
 * @Description TODO
 */
public class Main6 {

    // 奇怪的分式


    public static void main(String[] args) {

//        double a = 1,b = 1,c=1,d = 1;
        int ret = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) continue;
                for (int m = 1; m <= 9; m++) {
                    for (int n = 1; n <= 9; n++) {
                        if (m == n) continue;
                        boolean f = check(i, j, m, n);
                        if(f)ret++;
                    }
                }
            }
        }
        System.out.println(ret);
    }

    private static boolean check(int i, int j, int m, int n) {

        int x1 = i * m;
        int y1 = j * n;

        int k = gcd(x1, y1);

        x1 /= k;
        y1 /= k;

        int x2 = i * 10 + m;
        int y2 = j * 10 + n;
        k = gcd(x2,y2);

        x2 /= k;
        y2 /= k;

        return x1==x2 && y1==y2;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
