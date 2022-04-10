package basic;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 十六进制转十进制
 * @date 2022-03-22 19:39
 * @Description TODO
 */
public class 十六进制转十进制 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String h = sc.next();

        String toBin = toBinary(h);
        String toDec = toDecimal(toBin);
        System.out.println(toDec);

    }

    private static String toDecimal(String toBin) {

        // 按权加
        int len = toBin.length();
        char[] chs = toBin.toCharArray();
        long ret = 0;
        int cnt = 0;
        for(int i=len-1;i>=0;i--){
            ret += (chs[i]-'0')*Math.pow(2,cnt++);
        }
        return String.valueOf(ret);
    }

    private static String toBinary(String h) {
        StringBuilder sb = new StringBuilder();

        int len = h.length();

        for(char ch : h.toCharArray()){
            switch (ch){
                case '0':sb.append("0000");break;
                case '1':sb.append("0001");break;
                case '2':sb.append("0010");break;
                case '3':sb.append("0011");break;
                case '4':sb.append("0100");break;
                case '5':sb.append("0101");break;
                case '6':sb.append("0110");break;
                case '7':sb.append("0111");break;
                case '8':sb.append("1000");break;
                case '9':sb.append("1001");break;
                case 'A':sb.append("1010");break;
                case 'B':sb.append("1011");break;
                case 'C':sb.append("1100");break;
                case 'D':sb.append("1101");break;
                case 'E':sb.append("1110");break;
                case 'F':sb.append("1111");break;
                default:break;
            }
        }

        return sb.toString();

    }


    public static String h2d(String h){
        // 使用api Long
        long i = Long.parseLong(h, 16);

        return String.valueOf(i);
    }

}
