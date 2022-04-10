package _week._46;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 取石子
 * @date 2022-04-09 19:00
 * @Description TODO
 */
public class 取石子 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(),n2 = sc.nextInt();
        int k1 = sc.nextInt(),k2 = sc.nextInt();

        if(n2/k2 >= n1 || n2>=n1){
            System.out.println("Second");
        }else if(n1/k1 >= n2 || n1 > n2 ){
            System.out.println("First");
        }
    }

}
