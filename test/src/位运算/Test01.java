package 位运算;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname Test01
 * @date 2022-03-25 13:41
 * @Description TODO
 */
public class Test01 {


    public static void main(String[] args) {
        int[] test = {1,2,3};
        swap(test,0,2);
        Arrays.stream(test).forEach(o -> System.out.printf("%d",o));
    }

    public static void swap(int[] nums,int i,int j){
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

}
