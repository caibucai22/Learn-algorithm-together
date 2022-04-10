package competition.unclassfied;

/**
 * @author Csy
 * @Classname 抽签
 * @date 2022-03-24 14:57
 * @Description TODO
 */
public class 抽签 {

    static int[] a = {4,2,2};
    static int cnt = 0;
    public static void main(String[] args) {

        dfs(0,5,"");
//        System.out.println(cnt);
    }

    private static void dfs(int start,int sum,String path){
        if(start == a.length){
            // 计算人数 打印方案
            if(sum == 0){
                cnt++;
                System.out.println(path);
            }
            return;
        }
        String s = path;
        for(int i=0;i<=a[start];i++){

            sum -= i;
            for(int j=1;j<=i;j++){
                s = s+(char)('A'+start);
            }
            dfs(start+1,sum,s);
            s = s.substring(0,s.length()-i);
            sum += i;
        }
    }

}

// 1 2 2
// 2 1 2
// 2 2 1
// 3 0 2
// 3 1 1
// 3 2 0
// 4 0 1
// 4 1 0

