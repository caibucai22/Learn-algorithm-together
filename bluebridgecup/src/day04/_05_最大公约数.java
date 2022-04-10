package day04;

/**
 * @author Csy
 * @Classname _05_最大公约数
 * @date 2022-01-22 10:13
 * @Description TODO
 */
public class _05_最大公约数 {

    public static void main(String[] args) {


    }

    static int gcd(int m,int n){
        if(n==0) return m;

        return gcd(n,m%n);
    }
}
