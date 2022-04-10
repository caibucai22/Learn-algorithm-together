import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Csy
 * @Classname 线性分类器
 * @date 2022-03-14 15:19
 * @Description TODO
 */
public class 线性分类器 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        Map<String, String> A = new HashMap<String, String>();
        Map<String, String> A_ = new HashMap<String, String>();
        Map<String, String> B = new HashMap<String, String>();
        // 数据范围 0-1000,

        // 三种分割线 横线 竖线 斜线 a b=0 横线  c = 0 竖线

        // Map a 放a类点  b 放b类点  然后 a_ 放划分后的a类点
        // 比较 a c 是否相同 相同就能划分开 不同就不能划分开

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            String c = sc.next();
            String p = x + " " + y;
            if ("A".equals(c)) {
                A.put(p, "A");
            } else if ("B".equals(c)) {
                B.put(p, "B");
            }
        }

        while (m-- > 0) {
            // > 0 划分为 a类
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            for (String p : A.keySet()) {
                int idx = p.indexOf(" ");
                int x = Integer.parseInt(p.substring(0, idx));
                int y = Integer.parseInt(p.substring(idx + 1, p.length()));

                if (than0(a, b, c, x, y)) {
                    A_.put(p, ">");
                }
            }

            // 比较是否 A_ 中的点 是全是A类 还是B类
            // 因为不确定A类点 是全部大于0 还是小于0
            // 划分得到的A_ 是全部大于0的，可能是A 或 B

            boolean isAllA = true, isAllB = true;
            for (String p : A.keySet()) {
                if (!A_.containsKey(p)) {
                    isAllA = false;
                    break;
                }
            }
            for (String p : B.keySet()) {
                if (!A_.containsKey(p)) {
                    isAllB = false;
                    break;
                }
            }

            if ((isAllA && A.size() == A_.size()) || (isAllB && B.size() == A_.size())) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean than0(int a, int b, int c, int x, int y) {

        if (b != 0 && c != 0) {
            return a + b * x + c * y > 0;
        } else if (b == 0) { // 横线 比较 y
            double y_ = -a / c * 1.0;
            return y > y_;
        } else if (c == 0) { // 竖线 比较 x
            double x_ = -a / b * 1.0;
            return x > x_;
        }

        // 没有机会走到这里
        return false;
    }

}

