package competition.unclassfied2;


import java.util.*;

/**
 * @author Csy
 * @Classname 日期问题
 * @date 2022-03-31 12:40
 * @Description TODO  改了7变，我服了，日期问题一定要考虑闰年问题，二月天数情况，可能存在的去重情况treeset
 */
public class 日期问题 {

    static int[] hash = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        // 60-99 00-59
        // 年-月-日
        // 月-日-年
        // 日-月-年
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split("/");
        int a = Integer.parseInt(s[0]),
                b = Integer.parseInt(s[1]),
                c = Integer.parseInt(s[2]);
        List<String> ret = new ArrayList<>();
        if (check1(a, b, c)) {
            if (a >= 60) {
                ret.add(String.format("19%02d-%02d-%02d", a, b, c));
            } else {
                ret.add(String.format("20%02d-%02d-%02d", a, b, c));
            }

//            System.out.printf("20%02d-%02d-%02d\n", a, b, c);
        }
        if (check2(a, b, c)) {
            if (c >= 60) {
                ret.add(String.format("19%02d-%02d-%02d", c, a, b));
            } else {
                ret.add(String.format("20%02d-%02d-%02d", c, a, b));
            }
//            ret.add(String.format("20%02d-%02d-%02d", c, a, b));
//            System.out.printf("20%02d-%02d-%02d\n", c, a, b);
        }
        if (check3(a, b, c)) {
            if (c >= 60) {
                ret.add(String.format("19%02d-%02d-%02d", c, b, a));
            } else {
                ret.add(String.format("20%02d-%02d-%02d", c, b, a));
            }
//            ret.add(String.format("20%02d-%02d-%02d", c, b, a));
//            System.out.printf("20%02d-%02d-%02d\n", c, b, a);
        }

        Collections.sort(ret);
        Set<String> set = new TreeSet<>(ret);
        set.stream().forEach(o -> {
            System.out.println(o);
        });

    }

    private static boolean check1(int year, int month, int day) {
        if (isRun(year)) hash[2] = 29;
        boolean f = (month >= 1 && month <= 12) && (day >= 1 && day <= 31) && day <= hash[month];
        hash[2] = 28;
        return f;
    }

    private static boolean check2(int month, int day, int year) {
        if (isRun(year)) hash[2] = 29;
        boolean f = (month >= 1 && month <= 12) && (day >= 1 && day <= 31) && day <= hash[month];
        hash[2] = 28;
        return f;
    }

    private static boolean check3(int day, int month, int year) {
        if (isRun(year)) hash[2] = 29;
        boolean f = (month >= 1 && month <= 12) && (day >= 1 && day <= 31) && day <= hash[month];
        hash[2] = 28;
        return f;
    }


    private static boolean isRun(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
