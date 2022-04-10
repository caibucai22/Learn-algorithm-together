package day03;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname _03_2的整数次方
 * @date 2022-01-21 11:00
 * @Description 用一条语句判断一个整数是不是2的整数次方
 */
public class _03_2的整数次方 {

    public static void main(String[] args) {

        // 即判断 2进制里面是否只有一个1

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 右移



        // 左移

        // 减1
        boolean ret = ((N-1)&N) == 0;
        System.out.println(ret);
    }
}
