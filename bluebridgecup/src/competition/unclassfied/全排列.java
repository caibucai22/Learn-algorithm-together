package competition.unclassfied;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname 全排列
 * @date 2022-03-24 15:24
 * @Description TODO
 */
public class 全排列 {

    static int[] a = {1,1,1,2,2,3,3,3};
    static boolean[] used;


    public static void main(String[] args) {

        dfs(0);

    }


    private static void dfs(int start){
        if(start == a.length){
            // 输出全排列
            Arrays.stream(a).forEach(o -> System.out.printf("%d",o));
            System.out.println();
        }

        // 这里 i = start 而不是 i = 0 开始 全排列是n! 不是 n^n
        for(int i=start;i<a.length;i++){
            swap(a,start,i);

            dfs(start+1);

            // recover
            swap(a,start,i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
