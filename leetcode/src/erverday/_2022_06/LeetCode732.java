package erverday._2022_06;

import java.util.HashMap;

/**
 * @author Csy
 * @Classname LeetCode732
 * @date 2022-06-07 17:03
 * @Description TODO
 */
public class LeetCode732 {
}

class MyCalendarThree {

    // 分析 每个连续区间 预订次数 的最大值
    //
    private HashMap<Integer,Integer> tree;
    private HashMap<Integer,Integer> lazy;
    public MyCalendarThree() {
        tree = new HashMap<>();
        lazy = new HashMap<>();
    }

    public int book(int start, int end) {
        update(start,end-1,0,1000000000,1);
        return tree.getOrDefault(1,0);
    }

    public void update(int start,int end,int l,int r,int idx){
        if(r < start || end < l)return;

        if(start <= l && r <= end){
            tree.put(idx,tree.getOrDefault(idx,0)+1);
            lazy.put(idx,lazy.getOrDefault(idx,0)+1);
        }else{
            int mid = (l+r)>>1;
            update(start,end,l,mid,idx<<1);
            update(start,end,mid+1,r,idx<<1|1);
            tree.put(idx,lazy.getOrDefault(idx,0)+Math.max(
                    tree.getOrDefault(idx<<1,0),
                    tree.getOrDefault(idx<<1|1,0)
            ));
        }
    }
}