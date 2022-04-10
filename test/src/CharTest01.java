import java.util.Scanner;

/**
 * @author Csy
 * @Classname CharTest01
 * @date 2022-03-19 19:53
 * @Description TODO
 */
public class CharTest01 {

    public static void main(String[] args) {

//        char ch1 = ''; // 不行
        char ch2 = '\0';
        // 相当于 两个空格键

//        String str = new String(ch2); // 不行
        System.out.println("  "+"2022");
        System.out.println(ch2 +"2022");


        Scanner sc = new Scanner(System.in);
//        char ch = (char) sc.nextInt();
        sc.nextInt();sc.nextInt();
        char ch = sc.next().charAt(0);
        System.out.println(ch);

    }

}
