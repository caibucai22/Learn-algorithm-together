package day04;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname _10_上楼梯
 * @date 2022-01-23 10:00
 * @Description 一次上1阶或2阶，或3阶
 */
public class _10_上楼梯 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            int upstairs = upstairs(n);
            System.out.println(upstairs);
        }

    }


    static int upstairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n==3){
            return 4;
        }

        return upstairs(n-1)+upstairs(n-2)+upstairs(n-3);
    }


}
