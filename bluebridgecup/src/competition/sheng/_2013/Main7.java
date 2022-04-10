package competition.sheng._2013;

import java.io.*;

/**
 * @author Csy
 * @Classname Main7
 * @date 2022-03-21 18:44
 * @Description TODO
 */
public class Main7 {


    // 错误票据


    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int N = 100001;
    static boolean[] st = new boolean[N];
    public static void main(String[] args) throws IOException {
        String[] N = in.readLine().split(" ");
        int n = Integer.parseInt(N[0]);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int r = -1,l = -1;

        while(n-- > 0){
            // 一项去重
            // 一次遍历 维持一个最小值和最大值 缩小区间
            String[] nums = in.readLine().split(" ");
            for(String num : nums){
                int idx = Integer.parseInt(num);
                if(st[idx] == false){
                    st[idx] = true;
                }else{
                    r = idx;
                }

                min = idx < min ? idx : min;
                max = idx > max ? idx : max;
            }
        }

        for(int i=min;i<=max;i++){
            if(st[i] == false){
                l = i;
            }
        }

//        System.out.println(l+" "+r);

        out.write(l+" "+r+"\n");

        in.close();
        out.flush();
        out.close();

    }

}
