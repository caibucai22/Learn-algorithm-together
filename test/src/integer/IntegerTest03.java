import org.junit.Test;

/**
 * @author Csy
 * @Classname Test03
 * @date 2022-03-07 15:02
 * @Description TODO
 */
public class Test03 {

    /**
     * 测试一些Java 中的好用api
     */

    @Test
    public void test01(){
        // 转换进制

        // 输入字符串 以所给对应进制进行解析 valueOf() 默认使用 10进制解析 指定radix 表示用所给进制解析
        String test = "10";
        int after1 = Integer.valueOf(test,2);
        //

        // 输入数字 转换为字符串
        int num = 10;
        String after2 = Integer.toString(num,8);

        // 解析为2进制
        String after3 = Integer.toBinaryString(num);
        // 解析为8进制
        String after4 = Integer.toOctalString(num);
        // 解析为16进制
        String after5 = Integer.toHexString(num);



        System.out.println(after1);
        System.out.println(after2);

        /**
         * 1. 所给进制不是10进制 可先转换为 10 进制 然后进一步转换  Integer.toString(num,radix);
         *
         * 2. 将所给的数 以二进制或其他进制解析 Integer.valueOf(num,radix)
         */
    }


}
