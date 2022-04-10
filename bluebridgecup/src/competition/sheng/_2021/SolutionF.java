package competition.sheng._2021;

import java.text.DecimalFormat;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname SolutionA
 * @date 2022-01-23 9:57
 * @Description TODO
 */
public class SolutionF {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long time = sc.nextLong()/1000;

        DecimalFormat df = new DecimalFormat("00");

        time %= 3600*24; // 对天取余
        int h = (int) (time/3600);
        time %= 3600;   // 对小时取余
        int m = (int) (time/60);
        int s = (int) (time%60); // 对分钟取余

        System.out.println(h+":"+m+":"+s);


//        Date date = new Date();
//        date.setTime(time);
//
//        System.out.printf("%tR",date);
    }

}
