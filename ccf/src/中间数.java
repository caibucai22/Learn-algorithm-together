import java.util.*;

/**
 * @author Csy
 * @Classname 中间数
 * @date 2022-03-10 16:58
 * @Description TODO
 */
public class 中间数 {

    static final int N = 1010;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 分析数据范围 1000个数

        // 想用hash统计来写
        Scanner sc = new Scanner(System.in);
        int[] hash = new int[N];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) {
            int t = sc.nextInt();
            nums[i] = t;
            map.put(t,map.getOrDefault(t, 0)+1);
        }
//        Arrays.sort(nums);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                // TODO Auto-generated method stub
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        int mid = -1;
        for(int i=0;i<n;i++) {
//            if(i>0 && nums[i]==nums[i-1])continue;
            // 查找小于 nums[i]的数lows 	n-lows-map.get(nums[i]) 就是大于 nums[i]的数
            int lows = 0;
            int highs = 0;
            for(Integer k : map.keySet()) {
                if(k < nums[i]) {
                    lows += map.get(k); // 统计小于它的数量
                }
                if(k > nums[i]){
                    highs += map.get(k);
                }
            }
            if(lows == highs) {
                mid = nums[i];
                break;
            }
        }
        System.out.println(mid);
    }
}
