package day04;

/**
 * @author Csy
 * @Classname _00_什么是递归
 * @date 2022-01-22 9:42
 * @Description TODO
 */
public class _00_什么是递归 {

    public static void main(String[] args) {


    }

    static void func(int i){
        // 递归出口
        if(i == 0){
            return;
        }
        func(i-1);

    }
}
