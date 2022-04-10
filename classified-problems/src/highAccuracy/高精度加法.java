package highAccuracy;

import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Csy
 * @Classname 高精度加法
 * @date 2022-03-09 16:02
 * @Description TODO
 */
public class 高精度加法 {

    // 高精度加法

    static List<Integer> A = new ArrayList<>();
    static List<Integer> B = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String a = sc.nextLine();
        String b = sc.nextLine();

        // 倒序存储
        for (int i = a.length() - 1; i >= 0; i--) A.add(a.charAt(i) - '0');

        for (int i = b.length() - 1; i >= 0; i--) B.add(b.charAt(i) - '0');

        List<Integer> C = add(A, B);

        // 倒序输出
        for(int i=C.size()-1;i>=0;i--) System.out.print(C.get(i));
    }

    public static List<Integer> add(List<Integer> A, List<Integer> B) {
        List<Integer> C = new ArrayList<>();
        int t = 0;
        // 表示进位
        for (int i = 0; i < A.size() || i < B.size(); i++) {
            if (i < A.size()) t += A.get(i);
            if (i < B.size()) t += B.get(i);
            C.add(t % 10);

            // 计算进位
            t /= 10;
        }
        if (t > 0) C.add(1);
        return C;
    }



    public static BigDecimal add2(BigDecimal a,BigDecimal b){

//        读取时用 scanner.nextBigDecimal()

        return a.add(b);
    }
}
