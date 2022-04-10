package beautiful_algorithm;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Csy
 * @Classname 素数环
 * @date 2022-03-24 18:46
 * @Description TODO
 */
public class 素数环 {


    static int[] a;
    static int n;
    static boolean[] used;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        used = new boolean[n+1];
//        dfs(0);
        // 从 0 会输出正确答案，但是 会出现一个环被循环输出的情况

        // 更精确
        a[0] = 1;
        used[1] = true;
        dfs(1);

    }

    private static void dfs(int start){
        if(start == n){
            if(isPrime(a[0]+a[n-1])) {
                Arrays.stream(a).forEach(o -> System.out.printf("%d", o));
                System.out.println();
            }
            return;
        }

        for(int i=1;i<=n;i++){
            if(!used[i]){
                if( start >0 && !isPrime(a[start-1]+i))continue;

                used[i] = true;
                a[start] = i;
                dfs(start+1);
                a[start] = -1;
                used[i] = false;
            }
        }
    }

    private static boolean isPrime(int a){
        if(a==1)return false;
        if(a==2)return true;
        for(int i=2;i*i<=a;i++){
            if(a%i == 0)return false;
        }
        return true;
    }

}
