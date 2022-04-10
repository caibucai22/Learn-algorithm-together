package competition.unclassfied3;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 解码
 * @date 2022-04-07 19:50
 * @Description TODO
 */
public class 解码 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] chs = sc.next().toCharArray();
        StringBuilder sb = new StringBuilder();
        int n = chs.length;
        int c = 0;
        for (int i = 0; i < n;) {
            if(Character.isLetter(chs[i])){
                sb.append(chs[i]);
                i++;
            }
            while (i < n && Character.isDigit(chs[i])) {
                c = c * 10 + (chs[i] - '0');
                i++;
            }
            if(c > 0){
                for(int j=0;j<c-1;j++)sb.append(sb.charAt(sb.length()-1));
                c = 0;
            }
        }
        System.out.println(sb.toString());

    }

}
