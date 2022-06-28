import org.junit.Test;

/**
 * @author Csy
 * @Classname IntegerTest01
 * @date 2022-03-22 19:50
 * @Description TODO
 */
public class IntegerTest01 {

    @Test
    public void test01(){
        int i = Integer.parseInt("39", 16);
        System.out.println(i);
        int ffff = Integer.parseInt("FFFF", 16);
        System.out.println(ffff);
    }

    @Test
    public void test02(){
        int i = Integer.parseInt("");
        System.out.println(i);
    }

}
