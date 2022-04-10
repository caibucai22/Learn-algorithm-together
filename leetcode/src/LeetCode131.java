import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Csy
 * @Classname LeetCode131
 * @date 2021-12-04 15:36
 * @Description TODO
 */
public class LeetCode131 {

    List<List<String>> ret = new ArrayList<>();
    Deque<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        // 回溯
        backTrack(s,0);

        return ret;
    }

    void backTrack(String s,int start){
        if(start>=s.length()){
            ret.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<s.length();i++){

            if(isPalindrome(s,start,i)){
                String substr = s.substring(start,i+1);
                path.addLast(substr);
            }else{
                continue;
            }

            // 递归核心
            backTrack(s,i+1);

            path.removeLast();
        }
    }

    boolean isPalindrome(String a,int start,int end){
        for(int i=start,j=end;i<j;i++,j--){
            if(a.charAt(i)!=a.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode131 solution = new LeetCode131();
        String test = "aab";
        List<List<String>> lists = solution.partition(test);

        lists.forEach(item -> System.out.println(item));
    }
}
