package Utils;

import java.util.Random;

/**
 * @author Csy
 * @Classname Util
 * @date 2022-01-31 11:13
 * @Description TODO
 */
public class Util {


    public static void main(String[] args) {

//        int[] test1 = {};
//        int[] test2 = null;
//        int[] test3 = {1};
//        int[] test4 = {1,2,3};
//
//        int max = getMaxValueOfArr(test4);
//
//        System.out.println(max);


//        int a = 123456;
//        int digitsOn = getDigitsOn(a, 6);
//        System.out.println(digitsOn);


        int[] ret = getRandomArrWithoutRepeat(0,100,10);
        for (int i : ret) {
            System.out.printf("%d ", i);
        }

    }

    public static int getMaxValueOfArr(int[] arr) {

        if (arr == null || arr.length < 1) {
            System.out.println("数组长度为空或为null");
            return -1;
        }

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }


    public static int getDigitsOn(int num, int d) {
        if (num < 0) {
            num = -num;
        }
        int len = String.valueOf(num).length();
        if (d > len) {
            System.out.println("超过所给数的位数");
            return -1;
        }
        return String.valueOf(num).charAt(len - d) - '0';
    }


    public static int[] getRandomArr(int start, int end, int n) {
        if (n > end - start + 1 || end < start) {
            System.out.println("无法生成该数列，请检查参数");
            return new int[0];
        }
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = random.nextInt(end);
            while (tmp < start) {
                tmp = random.nextInt(end);
            }
            arr[i] = tmp;
        }
        return arr;
    }

    public static int[] getRandomArrWithoutRepeat(int start, int end, int n) {
        if (n > end - start + 1 || end < start) {
            System.out.println("无法生成该数列，请检查参数");
            return new int[0];
        }
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = random.nextInt(end);
            // 检查该数字是否已经生成和 是否在范围内
            while (tmp < start || exist(arr,tmp)) {
                tmp = random.nextInt(end);
            }


            arr[i] = tmp;
        }
        return arr;
    }

    public static boolean exist(int[] arr,int e){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == e){
                return true;
            }
        }
        return false;
    }
}
