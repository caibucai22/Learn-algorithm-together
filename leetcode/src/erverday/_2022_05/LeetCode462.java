package erverday._2022_05;

import java.util.Arrays;

/**
 * @author Csy
 * @Classname erverday._2022_05.LeetCode462
 * @date 2022-05-19 10:42
 * @Description TODO
 */
public class LeetCode462 {

    public static void main(String[] args) {
        int[] a = {1,2,3,5,9};
        Solution462 s = new Solution462();
        int i = s.minMoves2(a);
        System.out.println(i);
    }
}

class Solution462 {
    public int minMoves2(int[] a) {
        Arrays.sort(a);
        int l = 0 ,r = a.length-1;
        int ret = 0;
        while(l < r){
            ret += a[r]-a[l];
            l++;
            r--;
        }
        return ret;
    }
}
