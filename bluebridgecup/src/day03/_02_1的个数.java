package day03;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname _02_1的个数
 * @date 2022-01-21 10:43
 * @Description TODO
 */
public class _02_1的个数 {

    public static void main(String[] args) {

        // 左移
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        System.out.println(Integer.toString(N,2));
        int count = 0;
        for(int i=0;i<32;i++){
            if((N&(1<<i))==(1<<i)){
                count++;
            }
        }

        System.out.println(count);

        // 右移
        int count2 = 0;
        for(int i=0;i<32;i++){
            if(((N>>i)&1)==1){
                count2++;
            }
        }
        System.out.println(count2);


        // 减1 后与自己相与
        int count3 = 0;
        while(N > 0){
            N=(N-1)&N;
            count3++;
        }
        System.out.println(count3);
    }
}
