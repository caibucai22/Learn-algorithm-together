package competition.sheng._2019;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Csy
 * @Classname 外卖店优先级2
 * @date 2022-03-23 19:54
 * @Description TODO 第一次写只过了两个点
 */
public class 外卖店优先级2 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] arg = in.readLine().split(" ");
        int N = Integer.parseInt(arg[0]);
        int M = Integer.parseInt(arg[1]);
        int T = Integer.parseInt(arg[2]);

        Order[] r = new Order[M];
        int[] last = new int[N+1];
        int[] cnt = new int[N+1]; // 统计优先级
        boolean[] st = new boolean[N+1]; // 是否在缓存中
        for(int i=0;i<M;i++){
            String[] row = in.readLine().split(" ");
            int ts = Integer.parseInt(row[0]),id = Integer.parseInt(row[1]);
            r[i] = new Order(ts,id);
        }

        Arrays.sort(r, Comparator.comparing((Order o) -> o.t).thenComparing((Order o)->o.id));

        for(int i=0;i<M;i++){
            Order o = r[i];
            int id = o.id,t = o.t;
            int time = t -last[id]-1; // 时间跨度
//            if(last[id] == t-1 || last[id] = t){ // 就在前一秒就接到了单 那么不需要扣除
//
//            }else{
//                cnt[id] -=  t -last[id]-1; // 减去距离上次得到订单扣除的优先级
//                cnt[id] = Math.max(cnt[id],0); // 避免负值
//
//                last[id] = t;// 更新时间
//            }

            // 与上面效果等价
//            cnt[id] -=  time; // 减去距离上次得到订单扣除的优先级
            // 这里减去的逻辑，当同一时间有多个订单时，t-last[id] = 0 就变成了 cnt[id] -= -1 不合逻辑

            cnt[id] -= Math.max(time,0); // 修改后 // 或者上面的if逻辑那样


            cnt[id] = Math.max(cnt[id],0); // 避免负值

            last[id] = t;// 更新时间



            if(cnt[id] <= 3)st[id] = false; // 判断出队
            cnt[id] += 2; // 加上此次接单增加的优先度
            if(cnt[id] > 5)st[id] = true; // 判断入队

        }

        // 最终时间跨度处理
        for(int i=1;i<=N;i++){
            if(last[i] < T){
                cnt[i] -= T-last[i];
                cnt[i] = Math.max(cnt[i],0); // 同样保证非负数(不加，没有影响）
                if(cnt[i] <= 3)st[i]= false;
            }
        }

        int ret = 0;
        for(boolean b:st){
            if(b)ret++;
        }
//        out.write(ret);
//        System.out.println(ret);

        in.close();
        out.flush();
        out.close();
    }

}
