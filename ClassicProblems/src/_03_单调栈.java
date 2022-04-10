import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author Csy
 * @Classname _03_单调栈
 * @date 2022-03-09 20:40
 * @Description Acwing 830 https://www.acwing.com/problem/content/832/
 */
public class _03_单调栈 {

    static final int N = 100010;

    public static void main(String[] args) {
        int[] stack = new int[N];
        int hh = 0, tt = 0;
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            while(tt > 0 && stack[tt] >= x){
                tt--;
            }
            if(tt <= 0){
                System.out.printf("%d ",-1);
            }else{
                System.out.printf("%d ",stack[tt]);
            }
            stack[++tt] = x;
        }
//        输出每个数左边第一个比它小的数
    }
}
