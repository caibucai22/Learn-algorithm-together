import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Csy
 * @Classname _04_全排列
 * @date 2022-03-09 22:58
 * @Description TODO acwing 3429 https://www.acwing.com/problem/content/3432/
 */
public class _04_全排列 {

    static List<List<Character>> ret = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chs = s.toCharArray();
        boolean[] visited = new boolean[chs.length];
        backTrack(chs, visited, new ArrayList<>());
        for (List<Character> str : ret) {
            str.forEach(a -> {
                System.out.print(a);
            });
            System.out.println();
        }

    }

    public static void backTrack(char[] chs, boolean[] visited, List<Character> path) {
        if (path.size() == chs.length) {
            ret.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < chs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(chs[i]);
                backTrack(chs, visited, path);

                // 撤销操作
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
