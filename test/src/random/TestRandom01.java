import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Csy
 * @Classname TestRandom01
 * @date 2022-04-08 23:11
 * @Description TODO
 */
public class TestRandom01 {

    public static void main(String[] args) {

        double random = Math.random();
        System.out.println(random);

    }

    @Test
    public void test(){
        Random random = new Random();
        int i = random.nextInt(10);
        IntStream ints = random.ints();
        List<Integer> collect = ints.limit(100).boxed().collect(Collectors.toList());



        System.out.println(i);
    }
}
