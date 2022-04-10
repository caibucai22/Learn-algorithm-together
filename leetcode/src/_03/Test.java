package _03;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname Test
 * @date 2022-02-15 10:43
 * @Description TODO
 */
public class Test {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
//        int min = Arrays.stream(a).min().getAsInt();
//        System.out.println(min);

//        reverse(a,5);
//        for (int i : a) {
//            System.out.printf("%d ", i);
//        }

        String test = "12+345i";
        String substring = test.substring(0, 2);
        String substring1 = test.substring(3, 6);
        System.out.printf("%S\n", substring);
        System.out.println(substring1);
    }

    public static void reverse(int[] arr,int len){
        int L = 0;
        int R = L + len - 1;
        while(L < R){
            int tmp = arr[L];
            arr[L] = arr[R];
            arr[R] = tmp;
            L++;
            R--;
        }
    }
}
