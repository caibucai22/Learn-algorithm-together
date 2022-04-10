package basic;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 十进制转十六进制
 * @date 2022-03-22 20:05
 * @Description TODO
 */
public class 十进制转十六进制 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        long d = Long.parseLong(str);
        if("0".equals(str)){
            System.out.println(0);
            return;
        }

        // 直接使用api
        System.out.println(Long.toHexString(0).toUpperCase());


        //
        System.out.println(d2h("0"));
    }


    public static String d2h(String d){
        long num = Long.parseLong(d);
        StringBuilder sb = new StringBuilder();

        while(num !=0){
            switch ((int)(num%16)){
                case 0:sb.append(0);break;
                case 1:sb.append(1);break;
                case 2:sb.append(2);break;
                case 3:sb.append(3);break;
                case 4:sb.append(4);break;
                case 5:sb.append(5);break;
                case 6:sb.append(6);break;
                case 7:sb.append(7);break;
                case 8:sb.append(8);break;
                case 9:sb.append(9);break;
                case 10:sb.append('A');break;
                case 11:sb.append('B');break;
                case 12:sb.append('C');break;
                case 13:sb.append('D');break;
                case 14:sb.append('E');break;
                case 15:sb.append('F');break;
                default:break;

            }
            num /= 16;
        }
        return sb.reverse().toString();
    }

}
