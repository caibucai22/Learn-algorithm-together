package competition.sheng._2013;

/**
 * @author Csy
 * @Classname Main2
 * @date 2022-03-21 16:50
 * @Description TODO
 */
public class Main2 {

    // 马虎的算式
    // 答案：142
    public static void main(String[] args) {

        int ret = 0;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {
                        for (int e = 1; e <= 9; e++) {

                            if (a != b && a != c && a != d && a != e && b != c && b != e && b != d
                                    && c != d && c != e && d != e) {
                                int left = (a * 10 + b) * (c * 100 + d * 10 + e);
                                int right = (a * 100 + d * 10 + b) * (c * 10 + e);
                                if (left == right) {
                                    ret++;
                                }
                            }


                        }
                    }
                }
            }
        }
        System.out.println(ret);

    }

}
