package leetcode;

/**
 * @author Csy
 * @Classname Test交替位二进制数
 * @date 2022-03-28 8:50
 * @Description TODO
 */
public class Test交替位二进制数 {

    public static void main(String[] args) {
        int n = 7;
        new Solution693().hasAlternatingBits(n);
    }

}

class Solution693 {
    public boolean hasAlternatingBits(int n) {
        int len = Integer.toBinaryString(n).length();
        for(int i=0;i<len-1;i++){
            if( ((n >> i)^(n>>(i+1))) == 0 )return false;
        }
        return true;
        // 5 0101 7 0111
        //1 ^ 0     11
    }
}