package basic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Csy
 * @Classname 特殊回文数
 * @date 2022-03-22 20:25
 * @Description TODO
 */
public class 特殊回文数 {


    static int n;

    public static void main(String[] args) {
        // n 1 - 54

        // 枚举一半 5位或六位
        /**
         * n为偶数
         */

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<Integer> ret = new ArrayList<>();

//        for(int n = 1;n<=54;n++){
//            System.out.println("<<<<<<<<<<<<<");

        // 这个做法少枚举了 内层从 0开始，刚开始设置从1开始了，而且输出无序，需要list存储排序后输出
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                int t = n - (i + j) * 2;
                if (t >= 0 && t <= 9) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i).append(j).append(t).append(j).append(i);
                    ret.add(Integer.parseInt(sb.toString()));
//                        System.out.printf("%d%d%d%d%d\n",i,j,t,j,i);
                }
                for (int k = 0; k <= 9; k++) {
                    if ((i + j + k) * 2 == n) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(i).append(j).append(k).append(k).append(j).append(i);
                        ret.add(Integer.parseInt(sb.toString()));
//                            System.out.printf("%d%d%d%d%d%d\n",i,j,k,k,j,i);
                    }
                }
            }
        }
//            System.out.println("=============");


        // 直接枚举从 10000 到 999999
//            for (int i = 10000; i < 999999; i++) {
//                if (i<=99999) {
//                    if ((i/10000)==(i%10)&&(i/1000%10)==(i/10%10)&&((i/10000)+i/1000%10+i/100%10+i/10%10+i%10)==n) {
//                        System.out.println(i);
//                    }
//                }
//                if (i>=100000) {
//                    if ((i/100000)==(i%10)&&(i/10000%10)==(i/10%10)&&(i/1000%10)==(i/100%10)&&(i/100000)+(i/10000%10)+(i/1000%10)+(i/100%10)+(i/10%10)+(i%10)==(n)) {
//                        System.out.println(i);
//                    }
//                }
//            }

//            System.out.println(">>>>>>>>>>>>>");
//            System.out.println();


        Collections.sort(ret);
        for (int num : ret) {
            System.out.println(num);
        }

    }


}


class Solution {

    StringBuilder path = new StringBuilder();

    public void findSpeicalHuiwen(int n) {
        dfs(0, path, n);
    }

    public void dfs(int idx, StringBuilder path, int n) {
        String l = path.toString();
        String r = path.reverse().toString();
        int a = 0, b = 0;
        if (!"".equals(l)) {
            a = Integer.parseInt(l);
            b = Integer.parseInt(r);
        }
        int remain = n - a - b;
        if (idx == 2) {
            if (remain < 10 && remain >= 0) {
                System.out.println(l + remain + r);
                return;
            }
        } else if (idx == 3) {
            if (a + b == n) {
                System.out.println(l + r);
                return;
            }
        }
        for (int i = idx; i < 3; i++) {
            for (int j = 1; j <= 9; j++) {
                path.append(j);
                dfs(idx + 1, path, n);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

}
