package day04;

/**
 * @author Csy
 * @Classname _01_n的阶乘
 * @date 2022-01-22 9:44
 * @Description TODO
 */
public class _01_n的阶乘 {

    public static void main(String[] args) {

        /**
         * 找重复 （求规模更小的子问题）
         * 找变化 变化的量应该作为参数
         * 找边界
         */
    }

    static int f1(int n){
        if(n==1){
            return 1;
        }
        return n * f1(n-1);
    }

    /**
     * 找重复
     * 找变化
     * 找边界 ：出口
     */

    static void f2(int i,int j){

        // 边界 出口
        if(i>j){
            return;
        }

        // 自己完成的部分
        System.out.println(i);

        // 剩余的部分
        f2(i+1,j);

    }
}
