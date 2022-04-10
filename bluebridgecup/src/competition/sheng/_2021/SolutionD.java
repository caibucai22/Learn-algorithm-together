package competition.sheng._2021;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Csy
 * @Classname SolutionA
 * @date 2022-01-23 9:57
 * @Description TODO
 */
public class SolutionD {
    static long n = 2021041820210418L;

    static List<Long> list = new ArrayList<>();

    static long count = 0;

    static Deque<Long> temp = new LinkedList<>();

    public static void main(String[] args) {


        // 找到所有因子
        for (long i = 1, end = (long) Math.sqrt(n); i <= end; i++) {
            if (n % i == 0) {
                list.add(i);
                list.add(n / i);
            }
        }

        // 去重
        list = list.stream().distinct().collect(Collectors.toList());

        dfs(0, 1);
    }

    private static void dfs(int begin, long now) {
        if(temp.size() == 3){
            if(now == n){
                count++;
            }
            return;
        }
        for(int i=begin;i<list.size();i++){
            temp.add(list.get(i));
            dfs(begin,now*list.get(i));
            temp.removeLast();
        }
    }
}
