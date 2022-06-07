package erverday._2022_06;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Csy
 * @Classname LeetCode929
 * @date 2022-06-04 15:27
 * @Description TODO
 */
public class LeetCode929 {

    public static void main(String[] args) {
        Solution929 s = new Solution929();
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
//        int i = s.numUniqueEmails(emails);
//        System.out.println(i);

        System.out.println("@".indexOf("test.email+alex@leetcode.com"));
    }
}

class Solution929 {
    public int numUniqueEmails(String[] emails) {
        // 解析 邮件地址
        // . 无效
        // + @ 中忽略
        Set<String> set = new HashSet<>();
        for(String email : emails){
            int idx = email.indexOf("@");
            String name = email.substring(0,idx);
            String host = email.substring(idx);
            if(name.contains(".")){
                name = name.replaceAll("\\.","");
            }
            if(name.contains("+")){
                // name = name.replace("\\+",""); 只有第一个 + 之前有效
                name = name.split("\\+")[0];
            }
            email = name+host;
            System.out.println(email);
            if(!set.contains(email)){
                set.add(email);
            }
        }
        return set.size();
    }
}
