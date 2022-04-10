package _02;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Csy
 * @Classname LeetCode2045
 * @date 2022-02-08 14:02
 * @Description TODO
 */
public class LeetCode2045 {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1,2},{1,3},{1,4},{3,4},{4,5}};
        int time = 3;
        int change = 5;

        Solution2045 solution2045 = new Solution2045();
        int ret = solution2045.secondMinimum(n,edges,time,change);

        System.out.println(ret);
    }
}

class Solution2045 {

    static int N = 10010, M = 4 * N, INF = 0x3f3f3f3f, index = 0; // 节点数,,游标
    // head 某个节点所对应边的集合 的头结点，e一条边的节点， ne是 找到下一条边
    static int[] head = new int[N], e = new int[M], ne = new int[M];

    // dist1 存储到每个节点的最短路径长度 ，dist2 存储次短路径长度
    static int[] dist1 = new int[N], dist2 = new int[N];

    // 向
    void add(int a, int b) {
        e[index] = b;
        ne[index] = head[a];
        head[a] = index;
        index++;
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // 因为可能存在很多条边，一种想法就是找出所有边需要花费的时间，
        // 然后找到后 进行排序 得到第二大时间

        // 存在一条最短路径，


        // 【宫水三叶】一题三解 :「堆优化 Dijkstra」&「BFS」

        // Dijkstra 能求出单源点 到达其他节点的值


        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        Arrays.fill(head, -1);
        index = 0;

        // 构造邻接表
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            add(u, v);
            add(v, u);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{1, 0});
        dist1[1] = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int u = poll[0], step = poll[1];

            // 遍历 当前节点的链表 得到 当前节点到其他节点的值
            for (int i = head[u]; i != -1; i = ne[i]) {
                int j = e[i];

                // 动态边权
                int a = step / change, b = step % change;
                int wait = a % 2 == 0 ? 0 : change - b;
                int dist = step + time + wait;
                if (dist1[j] > dist) {
                    dist2[j] = dist1[j];
                    dist1[j] = dist;
                    q.add(new int[]{j, dist1[j]});
                    q.add(new int[]{j, dist2[j]});
                } else if (dist1[j] < dist && dist < dist2[j]) {
                    dist2[j] = dist;
                    q.add(new int[]{j, dist2[j]});
                }
            }
        }
        System.out.println("123");
        // 得到 到目的节点的次最短路径
        return dist2[n];


    }
}
