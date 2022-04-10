/**
 * @author Csy
 * @Classname _05_区间合并
 * @date 2022-03-11 15:10
 * @Description TODO
 */
public class _05_区间合并 {

    public static void main(String[] args) {
        int s1 = 12,e1 = 15;
        int s2 = 13,e2 = 14;

        int inter = inter(s2, e2, s2, e2);
        System.out.printf("%d", inter);
    }

    public static int inter(int s1,int e1,int s2,int e2) {

        if(e1 <= s2 || e2 <= s1) {
            return 0;
        }

        return Math.min(e1, e2) - Math.max(s1, s2);

    }
}
