package beautiful_algorithm;

/**
 * @author Csy
 * @Classname 困难的串
 * @date 2022-03-24 19:17
 * @Description TODO
 */
public class 困难的串 {

    static int cnt = 0;

    public static void main(String[] args) {

        int n = 2;
        int l = 3;
        dfs(l,n,"");

    }

    private static void dfs(int l,int n,String prefix){
        if(n == 0){
            System.exit(0); // 直接退出 而不是继续回溯
        }

        for(char ch = 'A';ch<'A'+l;ch++){
            if(isHard(prefix,ch)){
                String t = prefix;
                System.out.println(prefix+ch);
//                cnt++;
                n--;
                dfs(l,n,prefix+ch);

                //
//                dfs(l,n--,prefix+ch); // n-- 先返回n 所以实质上n没有减一
//                prefix = t;
            }
        }

    }

    private static boolean isHard(String prefix,char ch){
        int count = 0;
        for(int j=prefix.length()-1;j>=0;j-=2){
            String sub1 = prefix.substring(j,j+count+1);
            String sub2 = prefix.substring(j+count+1)+ch;
            if(sub1.equals(sub2)){
                return false;
            }
            count++;
        }
        return true;
    }

}
