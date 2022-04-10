/**
 * @author Csy
 * @Classname LeetCode748
 * @date 2021-12-10 20:37
 * @Description TODO
 */
public class LeetCode748 {

    public static void main(String[] args) {
        String str = "GrC8950";
        String[] words = {"according", "level", "meeting", "none", "marriage", "rest"};

        Solution748 solution = new Solution748();
        String s = solution.shortestCompletingWord(str, words);
        System.out.println(s);
    }
}

class Solution748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {

        // 统计 license 中字母数量
        int[] hash = count(licensePlate);
        int min = Integer.MAX_VALUE;
        String ret = "";
        // 遍历words 中判断其字母数量是否满足hash要求
        for (String word : words) {
            int[] tmp = count(word);
            boolean match = judge(hash, tmp);
            // 判断大小写反了
            if (match && min > word.length()) {
                ret = word;
            }
        }
        return ret;

    }

    public int[] count(String str) {
        int[] hash = new int[26];
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                hash[ch - 'a']++;

            } else if (ch >= 'A' && ch <= 'Z') {
                hash[ch - 'A']++;
            }
        }
        return hash;
    }

    public boolean judge(int[] hash, int[] match) {
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {

//                不要写不等于,而是写具体 >
//                if(hash[i]!= match[i]){

                if (hash[i] > match[i]) {
                    return false;
                }
            }
        }
        return true;
    }


}


