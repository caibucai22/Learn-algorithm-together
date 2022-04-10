/**
 * @author Csy
 * @Classname Test牌型种数
 * @date 2022-03-24 14:36
 * @Description TODO
 */
public class Test牌型种数 {

    public static int count = 0 ;
    public static int[] a = new int[13];
    public static void dfs(int index) {
        if(index == 13) {
            int sum = 0;
            for(int i : a) {
                sum += i;
            }
            if(sum == 13) {
                count++;
            }
            return;
        }
        // 搜索
        for(int i=0; i<=4; i++) {
            a[index] = i;
            dfs(index+1);
        }
    }

    public static void main(String[] args) {
        dfs(0);
        System.out.println(count); // 答案是: 3598180
    }

}



