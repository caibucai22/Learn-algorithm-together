package competition.sheng._2021;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname SolutionA
 * @date 2022-01-23 9:57
 * @Description TODO
 */
public class 卡片 {
    /**
     * 小蓝有很多数字卡片，每张卡片上都是数字 0 到 9。
     * ​ 小蓝准备用这些卡片来拼一些数，他想从 1 开始拼出正整数，每拼一个，
     * 就保存起来，卡片就不能用来拼其它数了。
     * ​ 小蓝想知道自己能从 1 拼到多少。
     * ​ 例如，当小蓝有 30 张卡片，其中 0 到 9 各 3 张，则小蓝可以拼出 1 到 10，但是拼 11 时卡片 1 已经只有一张了，不够拼出 11。
     * ​ 现在小蓝手里有 0 到 9 的卡片各 2021 张，共 20210 张，请问小蓝可以从 1 拼到多少？
     */

    public static void main(String[] args) {
        int[] hash = new int[10];
        boolean stop = false;
        Arrays.fill(hash,2021);
        for(int i=1;;i++){
            char[] chs = Integer.toString(i).toCharArray();
            for(char ch:chs){
                hash[ch-'0']--;
            }
            // 判断卡片是否 <0  停止拼接 然后返回

            for(int num:hash){
                if(num <0 ){
                    stop = true;
                    break;
                }
            }
            if(stop){
                // 因为在拼当前这个数的时候，出现了排不足，所以只能返回上一个数 i-1
                System.out.println(i-1);
                break;
            }
        }

    }
}
