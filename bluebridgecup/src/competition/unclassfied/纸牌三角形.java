package competition.unclassfied;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname 纸牌三角形
 * @date 2022-03-24 14:11
 * @Description TODO
 */
public class 纸牌三角形 {


    static int[] a;
    static boolean[] used;
    static int cnt = 0;
    public static void main(String[] args) {
        a = new int[9];
        used = new boolean[10];
        Arrays.fill(a,-1);
        dfs(0);


        // cnt/6   /6 是分析得到
        System.out.println(cnt/6);

    }

    private static void dfs(int start){
        if(start == 9){
            check(a);
            return;
        }

        for(int i=1;i<=9;i++){
            if(!used[i]){
                used[i] = true;
                a[start] = i;
                dfs(start+1);
                a[start] = -1;
                used[i] = false;
            }

        }
    }


    private static void check(int[] a){
        // 左边 0 1 2 3 底边 3 4 5 6 右边 6 7 8 1
        int left = a[0]+a[1]+a[2]+a[3];
        int bottom = a[3]+a[4]+a[5]+a[6];
        int right = a[6]+a[7]+a[8]+a[1];

        if(left == right && left == bottom){
            cnt++;
        }
    }
}
