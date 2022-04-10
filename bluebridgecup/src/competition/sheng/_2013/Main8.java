package competition.sheng._2013;

import java.io.*;
/**
 * @author Csy
 * @Classname
 * @date 2022-03-21 19:00
 * @Description TODO
 */
public class Main8 {


    // 幸运数
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int N = 100001;
    static int[] st = new int[N];


    public static void main(String[] args) throws IOException {
        String[] strs = in.readLine().split(" ");
        int m = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);
        int ret = 0;
        for(int i = 1;i<N ;i++){
            st[i] = 1;
        }

        for(int i=2;i<=m;i++){

            if(st[i] > 0){
                for(int j=1,cnt = 0;j<=m;j++){
                    if(st[i] > 0){
                        cnt++;
                    }
                    if(cnt == st[i]){
                        st[j] = 0;
                        cnt = 0;
                    }
                }
            }

        }


        for(int i=m;i<=n;i++){
            if(st[i] > 0){
                ret++;
            }
        }

        out.write(ret+"\n");
        in.close();
        out.flush();
        out.close();


    }

}


