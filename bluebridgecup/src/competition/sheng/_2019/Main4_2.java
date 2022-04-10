package competition.sheng._2019;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Csy
 * @Classname Main4_2
 * @date 2022-03-27 9:07
 * @Description TODO dfs (这里面去重问题，好像不好整）
 */
public class Main4_2 {

    static boolean[] used;
    static int ret = 0;
    public static void main(String[] args) {
        used = new boolean[2020];
        List<Integer> path = new ArrayList<>();
        dfs(1,2019);
        System.out.println(ret);
    }

    private static void dfs(int start,int target){
        if(target < 0)return;
        if(start == 3 && target == 0){
            ret++;
            return;
        }

        for(int i=start;i<=2019;i++){
            if(target - i < 0)break;
            if(check(i))continue;
            target -= i;
            dfs(i+1,target); // i+1 这样做保障了一个递增
            target += i;
        }
    }

    private static boolean check(int num){
        String s = String.valueOf(num);
        char[] chs = s.toCharArray();

        for(char ch : chs){
            if(ch=='2'||ch=='4')return true;
        }
        return false;
    }

}
