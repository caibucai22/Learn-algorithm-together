package competition.sheng._2019;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname SolutionA
 * @date 2022-02-25 21:15
 * @Description TODO
 */
public class SolutionA {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] team = new int[20][5];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 5; j++) {
                team[i][j] = s.nextInt();
            }
        }

        int ret = Integer.MIN_VALUE;
        for (int i1 = 0; i1 < 20; i1++) {
            for (int i2 = 0; i2 < 20; i2++) {
                for (int i3 = 0; i3 < 20; i3++) {
                    for (int i4 = 0; i4 < 20; i4++) {
                        for (int i5 = 0; i5 < 20; i5++) {
                            if (i1 != i2 && i1 != i3 && i1 != i4 && i1 != i5
                                    && i2 != i3 && i2 != i4 && i2 != i5 && i3 != i4 &&
                                    i3 != i5 && i4 != i5) {
                                int max = team[i1][0] + team[i2][1] + team[i3][2] + team[i4][3] + team[i5][4];
                                ret = Math.max(ret, max);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ret);
    }
}
