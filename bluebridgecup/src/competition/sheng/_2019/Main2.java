package competition.sheng._2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Csy
 * @Classname Main2
 * @date 2022-03-23 17:18
 * @Description TODO
 */
public class Main2 {

    // 理解成求子序列了

    static Set<String> set;

    public static void main(String[] args) {
        set = new HashSet<>();
        // 不同子串 类似于求子集

        String str = "0100110001010001";
        char[] chs = str.toCharArray();
        List<Character> path = new ArrayList<>();
        dfs(chs, 0, path);

        System.out.println(set.size());
    }

    private static void dfs(char[] chs, int s, List<Character> path) {
        if (s == chs.length) {
            String str = toStr(path);
            set.add(str);
            return;
        }


        dfs(chs, s + 1, path);

        path.add(chs[s]);
        dfs(chs, s + 1, path);
        path.remove(path.size()-1);

    }

    private static String toStr(List<Character> path) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : path) {
            sb.append(ch);
        }
        return sb.toString();
    }

}
