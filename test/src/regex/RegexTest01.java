package regex;

import org.junit.Test;

/**
 * @author Csy
 * @Classname RegexTest01
 * @date 2022-06-04 15:39
 * @Description TODO
 */
public class RegexTest01 {


    @Test
    public void test01(){
        String email = "test.email+alex@leetcode.com";
        String s = email.replaceAll("\\.", "");
        System.out.println(s);

    }

}
