import java.util.Scanner;

/**
 * @author Csy
 * @Classname Acwing3358
 * @date 2022-03-14 23:09
 * @Description TODO
 */
public class Acwing3358 {

    static final int N = 30;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String alphet = sc.nextLine();

        char[] chs = alphet.toCharArray();
        int[] idx = new int[26];

        for(int i=0;i<chs.length;i++){
            char ch = chs[i];
            idx[ch-'a'] = i+1; // 记录每个字母的位置
        }

        String str = sc.next();
        int ret = 1; // 当发现第一个逆序关系已经是第二遍了，所以起始是1
        for(int i=0;i<str.length();i++){
            // 如果后面的字符比前面的字符小或等于 则就表示唱了一遍
            if(i > 0 && idx[str.charAt(i)-'a'] <= idx[str.charAt(i-1)-'a']){
                ret++;
            }
        }
        System.out.println(ret);
    }
}
