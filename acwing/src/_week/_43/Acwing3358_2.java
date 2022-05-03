package _week._43;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname _week._43.Acwing3358_2
 * @date 2022-03-14 23:18
 * @Description TODO
 */
public class Acwing3358_2 {

    static final int N = 30;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alph = sc.next();

        char[] chs = alph.toCharArray();

        String str = sc.next();
        int ret = 0;


        for (int i = 0; i < str.length();) {

            // 给每一个字符在字符表中找到一个对应 每找到也就唱了一遍
            for(int j=0;j<26;j++){
                if(str.charAt(i) == chs[j]){
                   i++;
                }
            }
            ret++;
        }
        System.out.println(ret);
    }
}

