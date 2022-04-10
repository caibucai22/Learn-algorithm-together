/**
 * @author Csy
 * @Classname _01_判断回文
 * @date 2022-02-08 12:08
 * @Description TODO
 */
public class _01_判断回文 {

    public static void main(String[] args) {
        boolean flag = isHuiWen01("b");
        System.out.println(flag);
    }

    public static boolean isHuiWen01(String str) {

        int n = str.length();
        int p1 = -1, p2 = -1;
        if (n % 2 == 0) {
            p1 = n / 2 - 1;
            p2 = n / 2;
        } else {
            p1 = p2 = n / 2;
        }
        while (p2 < n) {
            if (str.charAt(p1) != str.charAt(p2)) {
                return false;
            }
            p1--;
            p2++;

        }
        return true;
    }

}
