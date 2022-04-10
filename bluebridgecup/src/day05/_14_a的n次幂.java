package day05;

/**
 * @author Csy
 * @Classname _14_a的n次幂
 * @date 2022-01-23 11:00
 * @Description  设计算法实现 a的n次幂
 */
public class _14_a的n次幂 {

    public static void main(String[] args) {

        int a = 2,n=2;
        myPow(a,n);

        System.out.println(myPow2(2,0));
    }

    private static int myPow(int a, int n) {

        // 循环累乘
        if(n == 0){
            return 1;
        }
        int ret = 1;
        for(int i=1;i<=n;i++){
            ret *= a;
        }
        return ret;
    }

    private static int myPow2(int a, int n) {

        // 递归出口
        if(n == 0){
            return 1;
        }
        int ret = a;
        int ex = 1;
        while((ex<<1)<=n){
            ret = ret* ret;
            ex <<= 1;
        }

        // 还差多少次方

        return ret*myPow2(a,n-ex);

    }
}
