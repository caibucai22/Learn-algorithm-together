import org.junit.Test;

import java.util.*;
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
    public void test5() {
        String[] log = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        List<String> letLog = new ArrayList<>();
        List<String> digLog = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        for (String s : log) {
            int idx = s.indexOf(' ');
            String m = s.substring(0, idx);
            if (m.contains("dig")) {
                digLog.add(s);
            } else {
                letLog.add(s);
            }
        }
        Collections.sort(letLog, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int idx1 = o1.indexOf(' ');
                int idx2 = o2.indexOf(' ');
                String m1 = o1.substring(0, idx1);
                String m2 = o2.substring(0, idx2);
                String s1 = o1.substring(idx1);
                String s2 = o2.substring(idx2);
//                System.out.println(m1 + " " + s1);
//                System.out.println(m2 + " " + s2);
                if (s1.equals(s2)) {
                    return m1.compareTo(m2);
                } else {
                    return s1.compareTo(s2);
                }
            }
        });
        for (int i = 0; i < letLog.size(); i++) {
            ret.add(letLog.get(i));
        }

        for (int i = 0; i < digLog.size(); i++) {
            ret.add(digLog.get(i));
        }

        ret.forEach(o -> System.out.println(o));

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
//        Arrays.stream(test).max().getAsInt();
        int total = mean * (n + test.length);

        System.out.println(m + " " + total);
    }


    @Test
    public void test4() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
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
