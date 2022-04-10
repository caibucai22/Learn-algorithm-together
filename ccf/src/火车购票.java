import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Csy
 * @Classname 火车购票
 * @date 2022-03-10 16:15
 * @Description TODO
 */
public class 火车购票 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // 模拟火车情况 用hashmap 存储每一排还有多少空位 然后按键值大小排序

        // 每次买票 遍历 如果空位数 >= 此次购票数量 就分配给它
        // 同时用数组记录分配状态 便于输出下标

        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        boolean[] st = new boolean[101];
        // 初始化 20排 每排5个空位
        for(int i=1;i<=20;i++) {
            map.put(i, 5);
        }
        // 按键 从小到大进行排序
        Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(map);
        int n = sc.nextInt();
        while(n-- > 0) {
            int num = sc.nextInt();
            // 遍历找空位
            for(Integer empty: sortedMap.keySet()) {
                int cnt = num;
                int start =(int) ((empty-1)*5);

                if(sortedMap.get(empty) >= num) {

                    // 更新空位数
                    sortedMap.replace(empty, sortedMap.get(empty)-num);

                    // 输出位置
                    for(int i=start+1;i<=start+5;i++) {
                        if(!st[i] && cnt-- > 0) { // 如果没有被占有
                            System.out.print(i+" ");
                            st[i] = true;
                        }
                    }
                    // 只要找到了 满足票数的连续排数 就停止
                    break;
                }
            }
            System.out.println();
        }


    }
}
