import java.util.Scanner;

/**
 * @author Csy
 * @Classname Leetcode46Test02
 * @date 2022-03-06 16:26
 * @Description TODO
 */
public class Test02 {


    /**
     * 测试用scanner 读取 char
     *
     * 结果
     * 输入--+-+ 只能输出 -
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            System.out.println(sc.next().charAt(0));
//            //
//        }

        char[][] g = new char[5][5];
//        for(int i=0;i<5;i++) {
//            for(int j = 0;j<5;j++) {
//                g[i][j] = sc.next().charAt(j);
//                System.out.print(g[i][j]+" ");
//            }
//            System.out.println();
//        }

        for(int i=0;i<5;i++) {
            String str = sc.next();
            for(int j = 0;j<5;j++) {
                g[i][j] = str.charAt(j);
            }
        }

        for(int i=0;i<5;i++) {
            for(int j = 0;j<5;j++) {
                System.out.print(g[i][j]+" ");
            }
            System.out.println();
        }

        // 无法成功


    }


}
