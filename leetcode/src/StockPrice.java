import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Csy
 * @Classname StockPrice
 * @date 2022-01-23 15:27
 * @Description LeetCode 2034
 */
public class StockPrice {

    private Map<Integer,Integer> map;

    public StockPrice() {
        map = new HashMap<>();
    }

    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)){
            map.replace(timestamp,price);
        }else{
            map.put(timestamp,price);
        }
    }

    public int current() {
        Set<Integer> set = map.keySet();
        int cur = set.stream().max((time1,time2) -> time1-time2).get();
        return map.get(cur);
    }

    public int maximum() {
        return  map.values().stream().max((v1,v2) -> v1-v2).get();
    }

    public int minimum() {
        return map.values().stream().min((v1,v2) -> v1-v2).get();
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1,10);
        stockPrice.update(1,5);
        System.out.println(stockPrice.current());

        stockPrice.update(2,11);
        System.out.println(stockPrice.current());

        System.out.println(stockPrice.maximum());
        System.out.println(stockPrice.minimum());

    }
}
