import java.util.*;

/**
 * @author Csy
 * @Classname LeetCode380
 * @date 2022-04-13 12:53
 * @Description TODO O(1) 时间插入、删除和获取随机元素的数据结构 数组+哈希
 */
public class LeetCode380 {

    public static void main(String[] args) {
        RandomizedSet rSet = new RandomizedSet();
        rSet.insert(0);
        rSet.insert(1);
        rSet.insert(2);
        rSet.insert(3);
        rSet.insert(4);
        rSet.remove(0);
        int random = rSet.getRandom();
    }
}

class RandomizedSet {
    // o(1)时间插入、删除和获取随机元素： 数组
    // 还要保证不重复：hash
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(idx, last); // 将最后一个元素放到待删除元素的位置覆盖
        map.put(last, idx); // 不能放在最后一句
        // 最后一个元素也是第一个元素是 0 last = 0，idx = 0
        // 最后一个元素放入被删除元素的位置上还是0 但是后面的删除操作会把它删掉
        // 放在后面出现 又被重新添加的问题
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

