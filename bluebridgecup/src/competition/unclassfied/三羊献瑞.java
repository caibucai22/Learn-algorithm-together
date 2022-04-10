package competition.unclassfied;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname 三羊献瑞
 * @date 2022-03-24 12:26
 * @Description TODO
 */
public class 三羊献瑞 {


    static int[] a;
    static boolean[] used;
    public static void main(String[] args) {
        a = new int[8];
        used = new boolean[10];
        Arrays.fill(a,-1);

        dfs(0);
    }

    public static void dfs(int start){
        if(start == 8){
            int sum = (a[0]*1000+a[1]*100+a[2]*10+a[3])
                    +( a[4]*1000+a[5]*100+a[6]*10+a[1]);
            if(sum == a[4]*10000+a[5]*1000+a[2]*100+a[1]*10+a[7]){
                System.out.println(a[4]+" "+a[5]+" "+a[6]+" "+a[1]);
            }
            return;
        }


        for(int i=0;i<=9;i++){

            // 剪枝
            // 通过数学分析
            if(start==0 && i==0)continue;

            if(start == 4 && i!=1)continue; // 进位只可能是1

            // 不剪枝 会出现多组条件 通过观察 可以发现 只有 1085 符合
            if(!used[i]){
                used[i] = true;
                a[start] = i;
                dfs(start+1);
                a[start] = -1; // 这里同样式可回溯可不回溯
                used[i] = false;
            }
        }

    }

}
