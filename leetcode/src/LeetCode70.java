import java.util.Scanner;

/**
 * @author Csy
 * @Classname LeetCode70
 * @date 2021/10/7 21:16
 * @Description TODO
 */
public class LeetCode70 {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 0;
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 3; i <= n; i++) {
            c = a+b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }
}
