package day03;

/**
 * @author Csy
 * @Classname 落单的数
 * @date 2022-01-21 10:33
 * @Description 成双的数异或为0，单独的数与0异或为自己
 */
public class 落单的数 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,2,1,4,4};

        int ret = 0;
        for(int num:arr){
            ret = ret^num;
        }

        System.out.println(ret);

    }
}
