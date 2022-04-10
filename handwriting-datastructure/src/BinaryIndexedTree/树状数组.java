package BinaryIndexedTree;

/**
 * @author Csy
 * @Classname BinaryIndexedTree.树状数组
 * @date 2022-04-04 14:00
 * @Description TODO
 */
public class 树状数组 {



    int[] nums; //待维护数组
    int[] tree; //基于维护数组构造的差分数组实现的 树状数组

    // 构造出 基于维护数组构造的差分数组实现的 树状数组
    public void init(int[] nums){
        this.nums = nums;
        this.tree = new int[nums.length+10];

        for(int i=1;i<=nums.length;i++)rangeAdd(i,i,nums[i-1]);// 实现差分数组的方法
        /**
         * 注意事项
         * 最后一项时
         * l = i = num.length
         * r = i+1 = nums.length  会越界
         */
    }

    public int pointQuery(int index){
        int ret = 0;
        while(index > 0){
            ret += tree[index];
            index -= lowBit(index);
        }
        return ret;
    }

    public void rangeAdd(int l,int r,int val){
        add(l,val);
        add(r+1,-val);
    }

    private void add(int index,int v){
        while(index < tree.length){ // 细节处理 这里要保证index <= 原始数组元素的个数 tree[] 多开几个是没有影响的
            tree[index] += v;
            index += lowBit(index);
        }
    }
    private int lowBit(int x){
        return x & (-x);
    }


    public static void main(String[] args) {
        int[] test = {0,0,0,0,0,0,0,0,0,0};
        树状数组 s = new 树状数组();
        s.init(test);
        s.rangeAdd(1,9,1);
        s.rangeAdd(2,3,5);
        int i = s.pointQuery(2);
        System.out.println(i);
    }

}
