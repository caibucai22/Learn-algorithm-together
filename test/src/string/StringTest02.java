package string;

import org.junit.Test;

/**
 * @author Csy
 * @Classname StringTest02
 * @date 2022-05-29 16:15
 * @Description TODO
 */
public class StringTest02 {

    @Test
    public void test01(){
        String test = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        String[] split = test.split(":",-1);
        System.out.println(split.length);
        for (String s : split) {
            System.out.println(s);
        }
    }
}
