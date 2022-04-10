import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Csy
 * @Classname LeetCode500
 * @date 2021-10-31 21:26
 * @Description TODO
 */
public class LeetCode500 {
    public static String[] findWords(String[] words) {
        // 想法就是将三行字符放在三个char 数组中/ 三个哈希表
        String[] ret = null;
        List<String> retList = new ArrayList<>();
        Map<Character,Integer> row1 = new HashMap<>();
        Map<Character,Integer> row2 = new HashMap<>();
        Map<Character,Integer> row3 = new HashMap<>();
        boolean flag1 = true,flag2= true,flag3 = true;
        for(char ch:"qwertyuiop".toCharArray()){
            row1.put(ch,1);
        }
        for(char ch:"asdfghjkl".toCharArray()){
            row2.put(ch,1);
        }
        for(char ch:"zxcvbnm".toCharArray()){
            row3.put(ch,1);
        }
        // 然后再将待判定单词改为数组，然后遍历判断
        for(String word:words){
            for(char ch:word.toLowerCase().toCharArray()){
                if(!row1.containsKey(ch)){
                    flag1 = false;
                    break;
                }
            }
            for(char ch:word.toLowerCase().toCharArray()){
                if(!row2.containsKey(ch)){
                    flag2 = false;
                    break;
                }
            }
            for(char ch:word.toLowerCase().toCharArray()){
                if(!row3.containsKey(ch)){
                    flag3 = false;
                    break;
                }
            }


            if(flag1||flag2||flag3){
                retList.add(word);
            }
            flag1 = true;flag2= true;flag3 = true;
        }
        ret = retList.toArray(new String[retList.size()]);
        return ret;
    }

    public static void main(String[] args) {
        String[] test = {"Hello","Alaska","Dad","Peace"};
        String[] ret = findWords(test);
        for (String s : ret) {
            System.out.println(s);
        }
    }
}
