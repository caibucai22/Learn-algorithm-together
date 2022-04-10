/**
 * @author Csy
 * @Classname Test验证回文串
 * @date 2022-03-26 17:34
 * @Description TODO
 */
public class Test验证回文串 {

    public static void main(String[] args) {
        String test = "A man, a plan, a canal: Panama";
        boolean palindrome = new Solution2().isPalindrome(test);

    }

}
class Solution2 {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        s = s.toLowerCase();
        while(i<=j){
            char r = s.charAt(j);
            char l = s.charAt(i);
            while(r<'a'|| r >'z') j--;
            while(l<'a' || l > 'z')i++;

            if(r != l)return false;
            i++;
            j--;
        }
        return true;
    }
}
