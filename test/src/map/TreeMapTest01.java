import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * @author Csy
 * @Classname TreeMapTest01
 * @date 2022-03-10 15:46
 * @Description TODO
 */
public class TreeMapTest01 {

    // 测试 treemap 能否按照键的大小排序

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=20;i>=1;i--){
            map.put(i,5);
        }
        TreeMap<Integer,Integer> treeMap = new TreeMap<>(map);

        for (Integer integer : treeMap.keySet()) {
            System.out.print(integer+" ");
            int start = (int)(integer*Math.pow(5,integer-1));
        }
    }
}
