package day03;

/**
 * @author Csy
 * @Classname _05_浮点实数的二进制表示
 * @date 2022-01-21 19:07
 * @Description 0-1之间浮点实数的二进制表示
 */
public class _05_浮点实数的二进制表示 {

    public static void main(String[] args) {

        double num = 0.625;
        StringBuilder sb = new StringBuilder("0.");

        while (num > 0) {
            double r = num * 2;
            if (r >= 1) {
                sb.append(1);
                num = r - 1;
            } else {
                sb.append(0);
                num = r;
            }

            // 如果长度超过32位返回ERROR

            if(sb.length()>34){
                System.out.println("ERROR");
                return;
            }
        }

        System.out.println(sb.toString());
    }
}
