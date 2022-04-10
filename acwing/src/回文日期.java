

import java.util.Scanner;

/**
 * @author Csy
 * @Classname 回文日期
 * @date 2022-03-31 10:27
 * @Description TODO 10/12
 */
public class 回文日期 {


    static String sMon,sDay;
    static String eMon,eDay;
    public static void main(String[] args) {
        // 回文日期  一共8个数
        // 翻转前4个数，然后截取出月份和日期判断是否合法，如果合法就cnt++
        // 这里的合法包括 不能超过边界 月份 >=1 <=12 日 >=1 <= 31
        int cnt = 0;
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String e = sc.next();

        int start = Integer.parseInt(s.substring(0,4));
        sMon = s.substring(4,6);
        sDay = s.substring(6);

        int end = Integer.parseInt(e.substring(0,4));
        eMon = e.substring(4,6);
        eDay = e.substring(6);

        for(int i=start;i<=end;i++){
            StringBuilder sb = new StringBuilder().append(i);
            String t = sb.reverse().toString();
            int month = Integer.parseInt(t.substring(0,2));
            int day = Integer.parseInt(t.substring(2));

            if(isValid(start,end,month,day)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean isValid(int start,int end,int month,int day){
        if(month<=0||month>12)return false;
        if(day<=0 || day > 31)return false;

        int t = month*100+day;
        int min = Integer.parseInt(sMon)*100+Integer.parseInt(sDay);
        int max = Integer.parseInt(eMon)*100+Integer.parseInt(eDay);

        if(start==end && (t<min || t>max))return false;


        return true;
    }

}
