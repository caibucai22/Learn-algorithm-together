/**
 * @author Csy
 * @Classname Test纸牌三角形
 * @date 2022-03-24 14:23
 * @Description TODO
 */
public class Test纸牌三角形 {

    public static int[] a = new int[9];
    public static int[] visited = new int[] {0,0,0,0,0,0,0,0,0};
    public static int count = 0;
    public static void dfs(int index) {
        // 结束条件
        if(index == 9) {
            if(a[0]+a[1]+a[3]+a[5] == a[0]+a[2]+a[4]+a[8] &&
                    a[0]+a[1]+a[3]+a[5] == a[5]+a[6]+a[7]+a[8]) {
                count++;
            }
            return;
        }
        // 搜索
        for(int i=1; i<=9; i++) {
            if(visited[i-1] == 0) { // i从1开始，所以要i-1
                visited[i-1] = 1;
                a[index] = i;
                dfs(index+1);
                visited[i-1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        dfs(0);
        System.out.println(count/6);
    }

}

