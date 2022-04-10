package basic;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 十六进制转八进制
 * @date 2022-03-22 19:08
 * @Description TODO
 */
public class 十六进制转八进制 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next();
        }
        sc.close();

        for (int i = 0; i < n; i++) {
            String toBin = toBinary(a[i]);
            int len = toBin.length();
            if (len % 3 == 1) toBin = "00"+toBin;
            if (len % 3 == 2) toBin = "0"+toBin;
            String toOct = toOctal(toBin);
            System.out.println(toOct);
        }

    }

    private static String toOctal(String toBin) {
        StringBuilder sb = new StringBuilder();
        int len = toBin.length();
        int k =0;
        if(toBin.substring(0,3).equals("000")){
            k=3;
        }else{
            k=0;
        }
        for(int i=k;i<len-2;i+=3){
            switch (toBin.substring(i,i+3)){
                case "000":sb.append(0);break;
                case "001":sb.append(1);break;
                case "010":sb.append(2);break;
                case "011":sb.append(3);break;
                case "100":sb.append(4);break;
                case "101":sb.append(5);break;
                case "110":sb.append(6);break;
                case "111":sb.append(7);break;
                default:break;
            }
        }

        return sb.toString();
    }

    private static String toBinary(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<len;i++){
            switch (s.charAt(i)){
                case'0':sb.append("0000");break;
                case'1':sb.append("0001");break;
                case'2':sb.append("0010");break;
                case'3':sb.append("0011");break;
                case'4':sb.append("0100");break;
                case'5':sb.append("0101");break;
                case'6':sb.append("0110");break;
                case'7':sb.append("0111");break;
                case'8':sb.append("1000");break;
                case'9':sb.append("1001");break;
                case'A':sb.append("1010");break;
                case'B':sb.append("1011");break;
                case'C':sb.append("1100");break;
                case'D':sb.append("1101");break;
                case'E':sb.append("1110");break;
                case'F':sb.append("1111");break;
                default:break;
            }
        }

        return sb.toString();
    }
}
