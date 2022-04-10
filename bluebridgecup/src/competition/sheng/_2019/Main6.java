package competition.sheng._2019;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname Main6
 * @date 2022-03-23 19:22
 * @Description TODO
 */
public class Main6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = 0;
        for(int i=1;i<=n;i++){
            if(check(i))ret+=i;
        }

        System.out.println(ret);

    }

    private static boolean check(int i){

        while(i!=0){
            int t = i%10;
            if(t==2||t==0||t==1||t==9){
                return true;
            }
            i = i/10;
        }
        return false;
    }

}
