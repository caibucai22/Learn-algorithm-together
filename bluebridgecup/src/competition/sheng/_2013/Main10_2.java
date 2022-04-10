package competition.sheng._2013;

import java.io.*;
import java.util.Arrays;

/**
 * @author Csy
 * @Classname Main10_2
 * @date 2022-03-21 21:00
 * @Description TODO
 */
public class Main10_2 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static int ret = 0;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        int[] nums = new int[s.length];
        int[] raw = new int[s.length];
        for(int i=0;i<n;i++){
            raw[i] = nums[i] = Integer.parseInt(s[i]);

        }


        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                Arrays.sort(nums,i,j);
//                for(int s2 = i;s2<j;s2++){
//                    System.out.printf("%d ",nums[s2]);
//                }
//                System.out.println();

                if(check(nums, i, j)){
                    ret++;
                }

                // recover
                recover(raw,nums);
            }
        }

        out.write(ret+"\n");
        in.close();
        out.flush();
        out.close();


    }

    private static void recover(int[] raw, int[] nums) {
        for(int i=0;i<raw.length;i++){
            nums[i] = raw[i];
        }
    }

    private static boolean check(int[] nums, int i, int j) {
        if(j-i == 1)return true;
        for(int s = i;s<j;s++){
            if(s > 0 && nums[s-1]+1!=nums[s]){
                return false;
            }
        }
        return true;
    }

}
