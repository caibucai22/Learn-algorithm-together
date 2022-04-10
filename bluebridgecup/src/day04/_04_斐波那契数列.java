package day04;

/**
 * @author Csy
 * @Classname _04_斐波那契数列
 * @date 2022-01-22 10:01
 * @Description 求第n项
 */
public class _04_斐波那契数列 {

    public static void main(String[] args) {

        System.out.println(fib(3));
    }


    static int fib(int n){
        // 递归边界 出口
        if(n==2||n==1){
            return 1;
        }

        return fib(n-1) + fib(n-2);

    }
}
