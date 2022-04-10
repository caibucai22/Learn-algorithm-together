import java.io.*;

/**
 * @author Csy
 * @Classname 最长连续子序列
 * @date 2022-04-02 19:12
 * @Description TODO  不超过 k
 */
public class 最长连续子序列 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100010;
    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        String[] num = in.readLine().split(" ");
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(num[i]);
        }

        int l=0,r=0;
        int[] hash = new int[N];

        int len = 0;
        int type = 0;
        for(int i=0,j=0;i<n;i++){
            if(hash[a[i]] == 0){
                hash[a[i]]++;
                type++;
            }else{
                hash[a[i]]++;
            }

            while(type > k){
                if(hash[a[j]]  == 1){
                    hash[a[j]]--;
                    j++;
                    type--;
                }else{
                    hash[a[j]]--;
                    j++;
                }

            }

            if(i-j+1 > len && type <= k){
                len = i-j+1;
                l = j;
                r = i;
            }

        }
        System.out.println(l+1+" "+r+1);
    }



}
