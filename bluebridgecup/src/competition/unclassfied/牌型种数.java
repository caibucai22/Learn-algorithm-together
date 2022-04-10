package competition.unclassfied;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname 牌型种数
 * @date 2022-03-24 14:39
 * @Description TODO
 */
public class 牌型种数 {

    static int[] a;
    static int cnt1;
    static int cnt2;
    public static void main(String[] args) {
        a = new int[13];
        Arrays.fill(a,0);
//        cnt1 = 0;
//        dfs1(0);

        cnt2 = 0;
        dfs2(0,0); // dfs 更快一点 不涉及对数组的再次遍历求和

//        System.out.println(cnt1);
        System.out.println(cnt2);
    }

    private static void dfs1(int start){
        if(start == 13){
            check(a);
            return;
        }

        for(int i=0;i<5;i++){
            a[start] = i;
            dfs1(start+1);
//            a[start] = 0;
        }
    }

    private static void check(int[] a){
//        int sum = Arrays.stream(a).sum();
        // stream 流算不出来 ？？？

        int sum = 0;
        for(int i:a)sum+=i;
        if(sum == 13){
            cnt1++;
        }
    }

    private static void dfs2(int start,int sum){
        if(start == 13){
            if(sum == 13){
                cnt2++;
            }
            return;
        }

        for(int i=0;i<5;i++){
            sum += i;
            dfs2(start+1,sum);
            sum -= i;
        }
    }

}
