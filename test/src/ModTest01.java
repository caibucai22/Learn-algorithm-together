import org.junit.Test;

/**
 * @author Csy
 * @Classname ModTest01
 * @date 2022-04-01 12:25
 * @Description TODO
 */
public class ModTest01 {

    @Test
    public void test() {
        int a = -91;
        int mod = 10;
        int ret = a % mod;
//        int ret2 = getMod1(a,mod);
        int ret3 = getMod(a,mod);
        System.out.println(ret+" "+" "+ret3);
    }

    // getMod1 当如 a = -91 b=10 时 还是负的 所以无法映射到正余数
//    public int getMod1(int a, int b) {
//        return (a + b) % b;
//    }

    public int getMod(int a, int b) {
        return ((a % b) + b) % b;
    }

}
