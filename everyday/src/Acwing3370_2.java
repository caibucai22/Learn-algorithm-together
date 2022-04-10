/**
 * @author Csy
 * @Classname Acwing3370_2
 * @date 2022-03-15 23:35
 * @Description TODO
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Acwing3370_2 {

    static HashMap<String, Integer> zodiac = new HashMap<>();
    static HashMap<String, String> cows = new HashMap<>();
    static HashMap<String, Integer> years = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        cows.put("Bessie", "Ox");//初始化贝西的生肖和年龄，随便赋值
        years.put("Bessie", 2021);
        init();//初始生肖序列
        int n = Integer.parseInt(b.readLine());
        while (n-- > 0) {
            String[] str1 = b.readLine().split(" ");
            String now = str1[0];//本次的牛
            String pre = str1[7];//上次的牛
            int pre_zodiac = zodiac.get(cows.get(pre));//获取生肖下标
            int now_zodiac = zodiac.get(str1[4]);
            if (str1[3].equals("previous")) {
                int cur = pre_zodiac > now_zodiac ? pre_zodiac - now_zodiac : pre_zodiac + 12 - now_zodiac;
                cows.put(now, str1[4]);
                years.put(now, years.get(pre) - cur);
            } else {
                int cur = now_zodiac > pre_zodiac ? now_zodiac - pre_zodiac : now_zodiac + 12 - pre_zodiac;
                cows.put(now, str1[4]);
                years.put(now, years.get(pre) + cur);
            }
        }
        System.out.println(Math.abs(years.get("Bessie") - years.get("Elsie")));
    }

    public static void init() {
        zodiac.put("Ox", 1);
        zodiac.put("Tiger", 2);
        zodiac.put("Rabbit", 3);
        zodiac.put("Dragon", 4);
        zodiac.put("Snake", 5);
        zodiac.put("Horse", 6);
        zodiac.put("Goat", 7);
        zodiac.put("Monkey", 8);
        zodiac.put("Rooster", 9);
        zodiac.put("Dog", 10);
        zodiac.put("Pig", 11);
        zodiac.put("Rat", 12);
    }
}
//
//作者：晚风不温柔
//        链接：https://www.acwing.com/solution/content/100779/
//        来源：AcWing
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
