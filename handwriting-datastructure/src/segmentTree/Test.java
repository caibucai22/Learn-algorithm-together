package segmentTree;

/**
 * @author Csy
 * @Classname Test
 * @date 2022-03-05 14:29
 * @Description TODO
 */
public class Test {

    public static void main(String[] args) {

        Merger<Integer> merger = new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        };

        Integer[] data = new Integer[]{1, 4, 7, -4, 3};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(data, merger);

        segmentTree.printSegementTree();

        Integer query = segmentTree.query(1, 1);
        System.out.println(query);

        segmentTree.update(3,0);
        query = segmentTree.query(1, 4);
        System.out.println(query);

        SegmentTree2<Integer> segmentTree2 = new SegmentTree2<>(data,merger);
//
        segmentTree2.printSegementTree();
    }
}
