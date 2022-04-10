import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Csy
 * @Classname ArraysTest01
 * @date 2022-03-10 19:16
 * @Description TODO
 */
public class ArraysTest01 {

    public static void main(String[] args) {

        int[] test = {1, 3, 42, 1, 9, 0, 2};

        String[] test2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        Arrays.sort(test2);

        Arrays.sort(test, 0, 4);


        for (int i : test) {
//            System.out.printf("%d ", i);
        }

        for (String s : test2) {
            System.out.println(s);
        }
    }


    @Test
    public void test1() {
        boolean[] test = {true, true, false, true};
//        Arrays.binarySearch(test,false);
    }


    @Test
    public void test2() {
        Integer[] test = {2, 3, 1, 3, 4, 5};
        Arrays.sort(test, (Integer a, Integer b) -> {
            return b - a;
        });

        int[] test2 = {2, 3, 1, 3, 4, 5};
//        Arrays.sort(test2,new Comparator<Integer>(){
//            public int compare(int o1, int o2) {
//                return o2 - o1;
//            }
//        });

    }

    @Test
    public void test3() {
        int[] test = {4, 2, 2, 5, 4, 5, 4, 5, 3, 3, 6, 1, 2, 4, 2, 1, 6, 5, 4, 2, 3, 4, 2, 3, 3, 5, 4, 1, 4, 4, 5, 3, 6, 1, 5, 2, 3, 3, 6, 1, 6, 4, 1, 3};
        int mean = 2;
        int n = 53;

        int m = Arrays.stream(test).reduce(0, (sum, cur) -> sum += cur);
        int total = mean * (n + test.length);

        System.out.println(m + " " + total);
    }


    @Test
    public void test4() {
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);
        int[] ret = new int[list.size()];

        list.stream().forEach(o -> {
            int i = 0;
            ret[i] = o;
            i++;
        });// 这样写 不行 i是不变的 每次进来都是0

        for (int i : ret) {
            System.out.printf("%d ", i);
        }
    }

}
