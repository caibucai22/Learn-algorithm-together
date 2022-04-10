import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Csy
 * @Classname ListTest01
 * @date 2022-03-26 16:09
 * @Description TODO
 */
public class ListTest01 {


    @Test
    public void test01(){
        List<Integer> list = new ArrayList<>();
        int ret = 0;
        Integer reduce = list.stream().reduce(0, (sum, cur) -> sum += cur);
        System.out.printf("%d ", reduce);
    }

    @Test
    public void test02(){
        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(1);
        Integer reduce = list.stream().reduce(0, (xor, cur) -> xor ^= cur);
        System.out.println(reduce);
    }


    @Test
    public void test03(){
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0,2});
        list.add(new int[]{1,4});
        list.add(new int[]{2,1});
        list.add(new int[]{3,2});
        list.add(new int[]{4,5});

        Collections.sort(list,(o1,o2)-> {
//            if(o1[1] == o2[1])return o1[0]-o2[0];
            return o1[1]-o2[1];
        });

        for(int[] a : list){
            System.out.println(a[0]+"->"+a[1]);
        }

    }
}
