package _week._46;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 查询字符串
 * @date 2022-04-09 19:57
 * @Description TODO
 */
public class 查询字符串 {

    static int N = 100010;
    static int[][] tree = new int[N][27];
    static int total;
    static boolean[] end = new boolean[N];
    static String path = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "";
        for (int i = 0; i < n; i++) {
            s = sc.next();
            insert(s);
        }
        int q = sc.nextInt();
        while (q-- > 0) {
            s = sc.next();
            dfs(0, s);
        }
    }

    private static void insert(String str) {
        char[] chs = str.toCharArray();
        int len = chs.length;
        int root = 0;
        for (int i = 0; i < len; i++) {
            if (chs[i] == '.') {
                if (tree[root][26] == 0) tree[root][26] = ++total;
                root = tree[root][26];
            } else {
                int idx = chs[i] - 'a';
                if (tree[root][idx] == 0) tree[root][idx] = ++total;
                root = tree[root][idx];
            }
        }
        end[root] = true;
    }


    private static void dfs(int u, String s) {
        char[] chs = s.toCharArray();
        int len = s.length();
        if (u == len) {
            return;
        }

        int root = 0;
        for (int i = u; i < len; i++) {
            if(chs[i] == '.'){

            }else{
                int idx = chs[i] - 'a';
                if(tree[root][idx] == 0)return;
                root = tree[root][idx];
                path += (char)(idx+'a');
            }
        }
    }

}
