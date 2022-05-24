package erverday._2022_05;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname erverday._2022_05.LeetCode942
 * @date 2022-05-09 23:20
 * @Description TODO
 */
public class LeetCode942 {

    public static void main(String[] args) {
        String str = "IDID";
        Solution942 s = new Solution942();
        int[] ints = s.diStringMatch(str);
        Arrays.stream(ints).forEach(o -> System.out.println(o));
    }

}


class Solution942 {

    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ret = new int[n+1];
        int numI = 0,numD = n;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == 'I'){
                // 找到最小的可使用的数
                ret[i] = numI++;
            }else if(ch == 'D'){
                // 找到最大的可使用的数
                ret[i] = numD--;
            }
            ret[n] = numD;
            // ret[n] = numI;
            // 两个效果一样，
        }
        return ret;
    }
}