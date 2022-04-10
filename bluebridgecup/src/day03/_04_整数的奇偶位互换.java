package day03;

/**
 * @author Csy
 * @Classname _04_整数的奇偶位互换
 * @date 2022-01-21 11:03
 * @Description TODO
 */
public class _04_整数的奇偶位互换 {

    public static void main(String[] args) {
        int a = 6;
        int b = swap(a);

        System.out.println(9==b);

    }

    private static int swap(int i){
        int ou = i&0xaaaaaaaa; // 和1010 1010 1010 与运算得到偶数位
        int ji = i&0x55555555; // 和0101 0101 与运算得到奇数位

        return (ou>>1)^(ji<<1);
    }
}
