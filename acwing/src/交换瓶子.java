import java.io.*;

/**
 * @author Csy
 * @Classname 交换瓶子
 * @date 2022-03-29 22:07
 * @Description TODO
 */
public class 交换瓶子 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] a = in.readLine().split(" ");
        int n = Integer.parseInt(a[0]);
        String[] num = in.readLine().split(" ");
        int[] b = new int[n+1];
        for (int i = 1; i <= n; i++) b[i] = Integer.parseInt(num[i-1]);

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if(b[i] != i){
                for(int j= i+1;;j++){
                    if(b[j] == i){
                        swap(b,i,j);
                        cnt++;
                        break;
                    }
                }
            }else{

            }
        }

        System.out.println(cnt);

    }
    private static void swap(int[] b,int i,int j){
        b[i] ^= b[j];
        b[j] ^= b[i];
        b[i] ^= b[j];
    }

}
