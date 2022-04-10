/**
 * @author Csy
 * @Classname 快速幂
 * @date 2022-03-24 20:52
 * @Description TODO
 */
public class 快速幂 {

    public static void main(String[] args) {

    }

    public static int quickMi(int a, int b, int mod) {
        int ret = 1 % mod;
        int t = a;
        while (b > 0) {
            if ((b & 1) > 0) ret = ret * t % mod;
            t = t * t % mod;
            b = b >> 1;
        }
        return ret;
    }

}
