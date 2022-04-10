package list1;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 小玉买文具
 * @date 2022-03-26 21:58
 * @Description TODO
 */
public class 小玉买文具 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(),b = sc.nextInt();
        int n  = (a*10+b)/19;
        System.out.println(n);
    }

}
