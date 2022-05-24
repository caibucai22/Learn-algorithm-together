package erverday._2022_05;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Csy
 * @Classname erverday._2022_05.LeetCode433
 * @date 2022-05-07 23:37
 * @Description TODO
 */
public class LeetCode433 {

    public static void main(String[] args) {

    }

}
class Solution433 {
    public int minMutation(String start, String end, String[] bank) {
        // 将bank转换成hashset，这样查询就是o1时间复杂度
        Set<String> banker = Arrays.stream(bank).collect(Collectors.toSet());
        // 如果end不是有效基因，直接返回-1
        if(!banker.contains(end)){
            return -1;
        }
        // 创建个队列，以便于bfs遍历
        Deque<String> queue = new ArrayDeque<>();
        // 记录访问过的基因
        Set<String> visited = new HashSet<>();
        // 将start放入队列
        queue.offer(start);
        visited.add(start);
        int res = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            for(int num = 0; num < size; num++){
                String string = queue.poll();
                for(int i = 0; i < string.length(); i++){
                    StringBuilder str = new StringBuilder(string);
                    String[] change = new String[4];
                    change[0] = str.replace(i, i + 1, "A").toString();
                    change[1] = str.replace(i, i + 1, "C").toString();
                    change[2] = str.replace(i, i + 1, "G").toString();
                    change[3] = str.replace(i, i + 1, "T").toString();
                    for(int j = 0; j < 4; j++){
                        if(change[j].equals(end)){
                            return res;
                        }
                        if(banker.contains(change[j]) && !visited.contains(change[j])){
                            queue.offer(change[j]);
                            visited.add(change[j]);
                        }
                    }
                }
            }
        }
        return -1;
    }

}
