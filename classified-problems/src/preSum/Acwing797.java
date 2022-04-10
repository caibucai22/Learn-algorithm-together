package preSum;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname Acwing797
 * @date 2022-03-09 13:56
 * @Description TODO
 */
public class Acwing797 {


    // 差分

    static final int N = 10010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=1;i<=n;i++){
            insert(i,i,a[i]);
        }
        int m = sc.nextInt();
        while(m-- > 0){
            int l = sc.nextInt(),r = sc.nextInt(),c = sc.nextInt();
            insert(l,r,c);
        }
        int sum = b[0];
        for(int i=1;i<=n;i++){
            sum += b[i];
            System.out.print(sum+" ");
        }
    }

    public static void insert(int l,int r,int val){
        b[l] += val;
        b[r+1] -= val;
    }
}
