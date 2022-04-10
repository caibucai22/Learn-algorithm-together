package segmentTree;

/**
 * @author Csy
 * @Classname SegmentTree2
 * @date 2022-03-05 15:18
 * @Description TODO
 */
public class SegmentTree2<E> {

    /**
     * 线段树中传入的值，存储的副本
     */
    public E[] data;

    /**
     * 线段树中的节点，其中父节点的值为它的两个子节点merge后的值
     */
    public E[] tree;

    /**
     * 合成器，构造线段树时候同时传入合成器
     */
    public Merger<E> merger;

    /**
     * 构造线段树
     *
     * @param data   传入的数据
     * @param merger 传入的合成器
     */
    public SegmentTree2(E[] data, Merger<E> merger) {
        this.merger = merger;
        int length = data.length;
        this.data = (E[]) new Object[length];
        //复制数据到data中
        for (int i = 0; i < length; i++) {
            this.data[i] = data[i];
        }
        //总共n个叶子节点，n-1个非叶子节点
        tree = (E[]) new Object[length * 2 - 1];
        //构造线段树
        buildSegementTree(0, 0, length - 1);
    }

    /**
     * 构造线段树中的tree中的节点
     *
     * @param treeIndex tree中对应节点的index
     * @param left      这个节点对应data中的范围的左边界,root对应0
     * @param right     这个节点对应data中的范围的右边界,root对应length-1
     */
    public void buildSegementTree(int treeIndex, int left, int right) {
        if (left == right) {
            //如果left==right，证明递归结束，在对应的index设置data里left的值
            tree[treeIndex] = data[left];
            return;
        }
        //tree中父节点为treeIndex,的左右孩子的index
        int leftChildIndex = getLeftChild(treeIndex);
        int rightChildIndex = getRightChild(treeIndex);
        int mid = left + (right - left) / 2;
        //构造左右孩子节点
        buildSegementTree(leftChildIndex, left, mid);
        buildSegementTree(rightChildIndex, mid + 1, right);
        //根据左右孩子的值，通过合成器，决定父节点的值
        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    /**
     * 返回左孩子在数组中的位置
     *
     * @param index 父节点的index
     * @return 左孩子节点的index
     */
    public int getLeftChild(int index) {
        //可以这样看，root节点，index：0
        //root的左孩子，index：1
        //root的右孩子，index：2
        //root的左孩子的左孩子，index：3
        //root的左孩子的有孩子，index：4
        return 2 * index + 1;
    }

    /**
     * 返回右孩子在数组中的位置
     *
     * @param index 父节点的index
     * @return 右孩子节点的index
     */
    public int getRightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * 打印线段树
     */
    public void printSegementTree() {
        System.out.println("开始打印线段树----------");
        System.out.println("线段树数据的长度为" + data.length);
        for (int i = 0; i < tree.length; i++) {
            System.out.println("位置" + i + ": " + tree[i]);
        }

        System.out.println("打印线段树结束----------");
    }

    /**
     * 返回data中区间left和right间，对应的值
     *
     * @param left
     * @param right
     * @return
     */
    public E query(int left, int right) {
        if (left < 0 || right < 0 || left >= data.length || right >= data.length || left > right) {
            return null;
        }
        return queryRange(0, 0, data.length - 1, left, right);

    }

    /**
     * 在以tree中位置为treeIndex为根节点，而且该节点对应的data中的范围为[treeLeft,treeRight] <br>
     * 查询范围为[queryLeft,queryRight]对应的值
     *
     * @param treeIndex
     * @param treeLeft
     * @param treeRight
     * @param queryLeft
     * @param queryRight
     * @return
     */
    public E queryRange(int treeIndex, int treeLeft, int treeRight, int queryLeft, int queryRight) {
        if (treeLeft == queryLeft && treeRight == queryRight) {
            //如果该节点的范围正好对应查询范围，直接返回
            return tree[treeIndex];
        }
        int leftChildIndex = getLeftChild(treeIndex);
        int rightChildIndex = getRightChild(treeIndex);
        int mid = treeLeft + (treeRight - treeLeft) / 2;
        if (queryLeft >= mid + 1) {
            //如果查询范围仅仅对应左孩子或者右孩子
            return queryRange(rightChildIndex, mid + 1, treeRight, queryLeft, queryRight);
        } else {
            if (queryRight <= mid) {
                return queryRange(leftChildIndex, treeLeft, mid, queryLeft, queryRight);
            }
        }
        //查询范围，左右孩子都有
        E resultLeft = queryRange(leftChildIndex, treeLeft, mid, queryLeft, mid);
        E resultRight = queryRange(rightChildIndex, mid + 1, treeRight, mid + 1, queryRight);
        //最终结果是左右孩子的合并
        E result = merger.merge(resultLeft, resultRight);
        return result;
    }


    /**
     * 在线段树中修改data中index的元素，设置新的值为value
     *
     * @param index
     * @param value
     */
    public void set(int index, E value) {
        if (index < 0 || index >= data.length) {
            return;
        }
        setValue(0, 0, data.length - 1, index, value);
    }

    /**
     * 在以tree中位置为treeIndex为根节点，而且该节点对应的data中的范围为[treeLeft,treeRight] 下，<br>
     * 修改data中index的元素，设置新的值为value
     *
     * @param treeIndex
     * @param treeLeft
     * @param treeRight
     * @param index
     * @param value
     */
    public void setValue(int treeIndex, int treeLeft, int treeRight, int index, E value) {
        if (treeLeft == treeRight) {
            tree[treeIndex] = value;
            return;
        }
        int leftChildIndex = getLeftChild(treeIndex);
        int rightChildIndex = getRightChild(treeIndex);
        int mid = treeLeft + (treeRight - treeLeft) / 2;
        if (index <= mid) {
            setValue(leftChildIndex, treeLeft, mid, index, value);
        } else {
            setValue(rightChildIndex, mid + 1, treeRight, index, value);
        }
        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

}

