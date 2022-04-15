package _week._47;

import java.util.Scanner;
import java.io.*;

/**
 * @author Csy
 * @Classname _1883_删减
 * @date 2022-04-15 22:30
 * @Description TODO
 */
public class _1883_删减 {


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = in.readLine().toCharArray();
        String t = in.readLine();
        StringBuffer sb = new StringBuffer();
        //遍历s字符串一个一个向res中添加，如果res末尾的元素和t一样那么就删除末尾相同元素
        for (int i = 0; i < s.length; i++) {
            //向res中添加当前元素
            sb.append(s[i]);
            if (sb.length() >= t.length()) {
                if (sb.substring(sb.length() - t.length(), sb.length()).equals(t)) {
                    //如果res末尾的元素和t一样那么就删除末尾相同元素
                    sb.delete(sb.length() - t.length(), sb.length());
                }
            }
        }
        out.println(sb);
        out.flush();
    }
}

