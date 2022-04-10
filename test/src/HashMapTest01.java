import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Csy
 * @Classname HashMapTest01
 * @date 2022-03-10 16:35
 * @Description TODO
 */
public class HashMapTest01 {

    public static void main(String[] args) {

        // 测试 HashMap 的键 排列顺序
        // 当键是 有序录入时 是有序的 否则是无序的

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=10;i++){
            map.put(i,10);
        }

        for (Integer integer : map.keySet()) {
            System.out.printf("%d ", integer);
        }

    }


    @Test
    public void test01() {
        Map<Character,Integer> map = new HashMap<>();
        map.put('1',2);
        boolean allOne = !map.isEmpty() && map.entrySet().stream().filter(o -> o.getValue() == 1).count() == map.size();
        System.out.println(allOne);
    }
}
