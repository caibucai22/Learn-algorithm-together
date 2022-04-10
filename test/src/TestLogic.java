/**
 * @author Csy
 * @Classname TestLogic
 * @date 2022-03-24 20:55
 * @Description TODO
 */
public class TestLogic {

    // 测试一些逻辑运算

    public static void main(String[] args) {

        int x = 10;
        int a = x & 1; // 10 1010 & 0001 = 1010 ?
        int b = x | 1; // 1010 | 0001 = 1011

        int c = x^1; // 1010 ^ 0001 = 1011

        System.out.println("与运算"+a);
        System.out.println("或运算"+b);
        System.out.println("异或运算"+c);

    }
}
