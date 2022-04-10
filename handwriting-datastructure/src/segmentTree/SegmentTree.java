package segmentTree;

import java.util.Date;

/**
 * @author Csy
 * @Classname SegmentTree
 * @date 2022-03-05 14:09
 * @Description TODO
 */
public class SegmentTree<E> {


    private E[] data;

    private E[] tree;

    private Merger<E> merger;

    public SegmentTree(E[] data, Merger<E> merger) {
        this.merger = merger;
        int len = data.length;
        this.data = (E[]) new Object[len];
        // 把外部数据放入 内部 data 中

        for (int i = 0; i < len; i++) {
            this.data[i] = data[i];
        }

        // 直接使用系统方法 进行数组复制
//        System.arraycopy(data,0,this.data,len-1,len);


        this.tree = (E[]) new Object[len * 2 - 1];
        build(0, 0, len - 1);
    }

    private void build(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }

        int leftChildIdx = getLeftChild(treeIndex);
        int rightChildIdx = getRightChild(treeIndex);
//        int mid = left + ((right - left) >> 1);
        int mid = left + (right - left >> 1);

        // 位运算优先级 最低 一定要记得加括号 没加括号直接死循环 栈溢出

        build(leftChildIdx, left, mid);
        build(rightChildIdx, mid + 1, right);

        // 递归的方法 进行构建
        /**
         * 先将叶子节点附上值，然后再一层层回溯 计算父节点的值
         */
        tree[treeIndex] = merger.merge(tree[leftChildIdx], tree[rightChildIdx]);
    }

    /**
     * @param index
     * @return 这里的线段树 0 为根结点
     * 1 为左节点 2 为右节点
     * 3 4 为 1的左右节点
     * <p>
     * （如果是1为根结点 那就是 2*index  2*index+1）1 为根结点  2 3 为其左右节点
     * 4 5 为 2的左右节点 6 7 为 3的左右节点
     */

    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private int getRightChild(int index) {
        return 2 * index + 2;
    }

    public E query(int left, int right) {
        if (left < 0 || right < 0 || left >= data.length || right >= data.length
                || left > right) {
            throw new IllegalArgumentException("区间范围错误");
        }
        return queryRange(0, 0, data.length - 1, left, right);
    }

    private E queryRange(int treeIndex, int treeLeft, int treeRight, int queryLeft,
                         int queryRight) {

        if (treeLeft == queryLeft && treeRight == queryRight) {
            return tree[treeIndex];
        }

        int leftChildIdx = getLeftChild(treeIndex);
        int rightChildIdx = getRightChild(treeIndex);
        int mid = treeLeft + (treeRight - treeLeft >> 1);

        // 查询范围在右孩子
        if (queryLeft >= mid + 1) {
            return queryRange(rightChildIdx, mid + 1, treeRight, queryLeft, queryRight);
        } else if (queryRight <= mid) {
            // 查询范围在左孩子
            return queryRange(leftChildIdx, treeLeft, mid, queryLeft, queryRight);
        }

        // 左右都有
        E retLeft = queryRange(leftChildIdx, treeLeft, mid, queryLeft, mid);
        E retRight = queryRange(rightChildIdx, mid + 1, treeRight, mid + 1, queryRight);

        E result = merger.merge(retLeft, retRight);

        return result;
    }

    public void update(int index, E value) {
        if (index < 0 || index >= data.length) {
            return;
        }
        setValue(0, 0, data.length - 1, index, value);
    }

    private void setValue(int treeIndex, int treeLeft, int treeRight, int index, E value) {
        if (treeLeft == treeRight) {
            tree[treeIndex] = value;
            return;
        }
        int leftChildIdx = getLeftChild(treeIndex);
        int rightChildIdx = getRightChild(treeIndex);
        int mid = treeLeft + ((treeRight - treeLeft) >> 1);

        // 在左节点中查找
        if (index <= mid) {
            setValue(leftChildIdx, treeLeft, mid, index, value);
        } else {
            setValue(rightChildIdx, mid + 1, treeRight, index, value);
        }

        // 回溯时 更新父节点
        tree[treeIndex] = merger.merge(tree[leftChildIdx], tree[rightChildIdx]);
    }

    /**
     * 打印线段树
     */
    public void printSegementTree() {
        System.out.println("======开始打印线段树======");
        for (int i = 0; i < tree.length; i++) {
            System.out.println("位置" + i + ": " + tree[i]);
        }
        System.out.println("线段树数据长度为：" + data.length);
        System.out.println("======打印线段树结束======");
    }
}
