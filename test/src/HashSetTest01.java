import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Csy
 * @Classname HashSetTest01
 * @date 2022-04-17 21:42
 * @Description TODO
 */
public class HashSetTest01 {

    @Test
    public void test01(){
        String[] test = {"1","2","3","3"};
        Set<String> set = new HashSet<>(Arrays.asList(test));
        set.forEach(System.out::println);
    }

}
