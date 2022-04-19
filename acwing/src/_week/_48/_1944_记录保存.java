package _week._48;

import java.util.*;

/**
 * @author Csy
 * @Classname _1944_记录保存
 * @date 2022-04-19 13:09
 * @Description TODO
 */
public class _1944_记录保存 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[3];
        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            for (int i = 0; i < 3; i++) s[i] = sc.next();
            Arrays.sort(s);
            String tmp = "";
            for (int i = 0; i < 3; i++) tmp = tmp +"-"+ s[i];
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        int max = map.entrySet().stream().max((o1, o2) -> o1.getValue() - o2.getValue()).get().getValue();
        System.out.println(max);
    }
}
