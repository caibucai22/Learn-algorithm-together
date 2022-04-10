package competition.sheng._2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Csy
 * @Classname Main7
 * @date 2022-03-23 19:27
 * @Description TODO
 */
public class Main7 {

    // 2/10 就过了两个样例

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),M = sc.nextInt();
        int T = sc.nextInt();
        int[] stores = new int[N+1];
        Order[] orders = new Order[M];

        for(int i=0;i<M;i++){
            int t = sc.nextInt(),id = sc.nextInt();
            Order order = new Order(t,id);
            orders[i] = order;
        }

        Arrays.sort(orders,(o1,o2)->o1.t-o2.t);
//        Arrays.sort(orders, Comparator.comparing(((Order o)->o.t )));

        // M >= T
        int t = 1;
        while(t++ < T){
            int idx = -1;
            boolean[] st = new boolean[N+1]; // 更新有订单的
            for(int i=0;i<M;i++){
                if(orders[i].t == t){
                    idx = orders[i].id;
                    stores[idx]+=2;
                    st[idx] = true;
                }
            }

            // 更新无订单的
            for(int i=1;i<=N;i++){
                if( !st[i] && stores[i]>0)stores[i]--;
            }
        }
        int cache = 0;
        for(int i=1;i<=N;i++){
            if(stores[i] > 5){
                cache++;
            }
        }
        System.out.println(cache);

    }

}
class Order{
    int t;
    int id;

    public Order(int t, int id) {
        this.t = t;
        this.id = id;
    }
}

//4 9 6
//1 1
//5 2
//3 1
//6 2
//2 1
//6 2
//6 4
//6 4
//6 4

