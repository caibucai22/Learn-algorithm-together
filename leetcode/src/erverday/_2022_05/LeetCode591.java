package erverday._2022_05;

/**
 * @author Csy
 * @Classname erverday._2022_05.LeetCode591
 * @date 2022-05-02 13:33
 * @Description TODO 更多测试用例 见LeetCode
 */
public class LeetCode591 {

    public static void main(String[] args) {
        String[] test = {"<DIV>This is the first line <![CDATA[<div>]]></DIV>","<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>","<A>  <B> </A>   </B>"};
        Solution591 s = new Solution591();
        s.isValid(test[0]);
    }

}

class Solution591 {
    public boolean isValid(String code) {
        code = code.replaceAll("<!\\[CDATA\\[.*?\\]\\]>|t", "-");
        String temp = "";
        while (!temp.equals(code)) {
            temp = code;
            code = code.replaceFirst("<([A-Z]{1,9})>[^<]*</\\1>", "t");
        }
        return "t".equals(code);
    }
}