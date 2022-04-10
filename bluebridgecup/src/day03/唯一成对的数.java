package day03;


import sun.security.util.Length;

import java.util.Random;

/**
 * @author Csy
 * @Classname 唯一成对的数
 * @date 2022-01-21 10:04
 * @Description 两两异或成0，单独的那一个与0异或是自己
 */
public class 唯一成对的数 {

    public static void main(String[] args) {

        int N = 101;
        int[] arr = new int[N];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i+1;
        }

        // 最后一个数是随机数
        arr[arr.length-1] = new Random().nextInt(N-1)+1;

        // 随机下标
        int index = new Random().nextInt(N);

        // 与最后一个进行交换
        int tmp = arr[index];
        arr[index] = arr[arr.length-1];
        arr[arr.length-1] = tmp;

        // 打印输出
        for(int num : arr){
            System.out.print(num+" ");
        }
        System.out.println();
        // 异或得到的结果

        long start = System.currentTimeMillis();

        int x1 = 0;

        for(int i=1;i<=N-1;i++){
            x1 = (x1^i);
        }

        for(int i=0;i<N;i++){
            x1 = x1^arr[i];
        }

        System.out.println(x1);

        System.out.println("位运算花费时间"+(System.currentTimeMillis()-start));


        System.out.println("=================");

        long start2 = System.currentTimeMillis();

        int[] hash = new int[N];
        for(int num :arr){
            hash[num]++;
        }
        for(int i=0;i<N;i++){
            if(hash[i] == 2){
                System.out.println(i);
                break;
            }
        }
        System.out.println("位运算花费时间"+(System.currentTimeMillis()-start2));
    }
}
