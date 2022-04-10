package competition.unclassfied3;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 移动距离
 * @date 2022-03-31 11:11
 * @Description TODO
 */
public class 移动距离 {

    static int N = 500;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt(),m = sc.nextInt(),n = sc.nextInt();

        m--;n--; // 便于计算坐标
        int x1 = m/w,x2 = n/w;
        int y1 = m%w,y2 = n%w;

        if((x1 & 1) != 0){
            // 奇数行
            y1 = w-y1-1;
        }

        if((x2 & 1) != 0){
            // 奇数行
            // 8 1 4 6
            y2 = w-y2-1;
        }

        System.out.println(Math.abs(x1-x2)+Math.abs(x2-y2));
    }

}
