package day03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Csy
 * @Classname Test01
 * @date 2022-01-21 20:04
 * @Description TODO
 */
public class Test01 {

    public static void main(String[] args) {

        char[][] chs = new char[2][];
        chs[0] = new StringBuilder("10").reverse().toString().toCharArray();


        // 字符串无法直接翻转 使用 reverse()
        List<Integer> list = new ArrayList<>();
        List<Integer> tmp = list.stream().map(a -> a+1).collect(Collectors.toList());

        System.out.println(1<<2);
    }
}
