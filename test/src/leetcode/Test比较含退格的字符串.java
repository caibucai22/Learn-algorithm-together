package leetcode;

/**
 * @author Csy
 * @Classname Test比较含退格的字符串
 * @date 2022-03-29 21:25
 * @Description TODO
 */
public class Test比较含退格的字符串 {

    public static void main(String[] args) {
        Solution844 s = new Solution844();
        s.backspaceCompare("ab#c","ad#c");
    }

}


class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        String _s = f(s);
        String _t = f(t);
        return _s.equals(_t);
    }

    public String f(String s){
        char[] chs = s.toCharArray();
        int len = chs.length;
        int n = chs.length;
        for(int i=0;i<n-1;i++){
            if(chs[i+1] == '#'){
                for(int j = i;j<n-1;j++){
                    chs[j] = chs[j+1];
                }
                len--;
            }
        }
        return new String(chs,0,len);
    }
}
