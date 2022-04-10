package competition.unclassfied2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Csy
 * @Classname 日志统计
 * @date 2022-03-25 16:30
 * @Description TODO 滑动窗口
 */
public class 日志统计 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int M = (int) (1e5 + 10);

    static int[] ids = new int[M];
    static boolean[] st = new boolean[M];
    // ids st 每一个都是一个id


    public static void main(String[] args) throws IOException {
        String[] nums = in.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int D = Integer.parseInt(nums[1]);
        int K = Integer.parseInt(nums[2]);

        Record[] r = new Record[N];
        for (int i = 0; i < N; i++) {
            String[] record = in.readLine().split(" ");
            int t = Integer.parseInt(record[0]);
            int id = Integer.parseInt(record[1]);
            Record rec = new Record(t,id);
            r[i] = rec;
        }

//        Arrays.sort(r,0,N,(o1,o2)->o1.t - o2.t);
        // 按照时间排序
        Arrays.sort(r, 0, N, Comparator.comparing((Record o) -> o.t));

        // 滑动窗口 维持一个时间长度为 D的窗口
        for (int i = 0,j=0; i < N;i++) {
            int id = r[i].id;

            // 这种写法 不太行 出现死循环 或者 数组越界
//            while(r[i].t - r[j].t < D){
//                ids[id]++;
//                i++;
//            }
//            while(j<N && r[i].t - r[j].t >= D){
//                ids[r[j].id]--;
//                j++;
//
//                ids[id]++;
//                i++;
//            }

            ids[id]++;
            while(r[i].t - r[j].t >= D){
                ids[r[j].id]--;
                j++;
            }

            if(ids[id] >= K)st[id] = true;

        }

        // 遍历 是热帖输出

        for(int i=0;i<=100000;i++){
            if(st[i]) System.out.println(i);
        }


    }

}

class Record {
    int t;
    int id;

    public Record(int t, int id) {
        this.t = t;
        this.id = id;
    }
}
