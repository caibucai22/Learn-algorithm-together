package erverday._2022_05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Csy
 * @Classname LeetCode464
 * @date 2022-05-24 21:32
 * @Description TODO
 */
public class LeetCode464 {
}

class Solution464 {
    // boolean[] used = new boolean[21];
    Map<Integer,Boolean> cache = new HashMap<>();

    public boolean canIWin(int max, int total) {
        // 当所有数加起来 仍然小于目标时 先出 不可能赢 返回 false
        if(max*(max+1)*0.5 < total) return false;
        // 当max > total 时 先出 必赢
        if(max >= total)return true;

        return dfs(max,total,0);
    }

    private boolean dfs(int max,int u,int used){
        if(cache.containsKey(used)){
            // 记忆化搜索
            return cache.get(used);
        }

        for(int i=0;i<max;i++){
            int cur = (1<<i); // 选择第i个
            if((cur & used) == 0){
                // u <= i+1 表示当前选的这个数已经大于 剩下的值 直接返回true
                if( u <= i+1 || !dfs(max,u-(i+1),(cur|used)) ){
                    cache.put(used,true);
                    return true;
                }
            }
        }
        // 跳出循环 表示失败
        cache.put(used,false);
        return false;
    }
}
