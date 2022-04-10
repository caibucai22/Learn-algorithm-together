package competition.unclassfied;

import java.util.Arrays;


/**
 * @author Csy
 * @Classname 凑算式
 * @date 2022-03-24 13:16
 * @Description TODO
 */
public class 凑算式 {


    static double[] a;
    static boolean[] used;
    static int ans = 0;
    public static void main(String[] args) {

        a = new double[9];
        used = new boolean[10];

        Arrays.fill(a,-1.0);

        dfs(0);

        System.out.println(ans);

    }

    private static void dfs(int start) {
        if (start == 9) {
            check(a);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                a[start] = i;
                dfs(start + 1);
                a[start] = -1;
                used[i] = false;
            }
        }
    }


    private static void check(double[] a) {
        double ret = a[0] + (a[1]/a[2]) + ((a[3]*100+a[4]*10+a[5])/(a[6]*100+a[7]*10+a[8]));

        if(ret == 10){
//            Arrays.stream(a).forEach((double o) -> System.out.printf("%f ",o));
//            System.out.println();
            ans++;
        }

    }

}
