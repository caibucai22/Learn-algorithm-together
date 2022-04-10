package segmentTree;

public interface Merger<E> {

    /**
     *
     * @param a
     * @param b
     * @return 根据a和b 计算出父节点的值 具体实现可以使 最大值，最小值
     */

    public E merge(E a,E b) ;
}
