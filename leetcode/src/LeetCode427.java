/**
 * @author Csy
 * @Classname LeetCode427
 * @date 2022-04-29 16:32
 * @Description TODO 四叉树
 */
public class LeetCode427 {

    public static void main(String[] args) {
        int[][] test = {{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1}, {
                1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {
                1, 1, 1, 1, 0, 0, 0, 0}};
        Solution427 s = new Solution427();
        Node root = s.construct(test);

    }
}


class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

class Solution427 {
    public Node construct(int[][] grid) {
        return quadTree(grid, 0, 0, grid.length);
    }

    private Node quadTree(int[][] grid, int x, int y, int offset) {
        if (offset <= 0) return null;

        for (int i = x; i < x + offset; i++) {
            for (int j = y; j < y + offset; j++) {
                if (grid[i][j] != grid[x][y]) {
                    return new Node(false, false,
                            quadTree(grid, x, y, offset / 2),
                            quadTree(grid, x + offset / 2, y, offset / 2),
                            quadTree(grid, x, y + offset / 2, offset / 2),
                            quadTree(grid, x + offset / 2, y + offset / 2, offset / 2)
                    );
                }
            }
        }
        return new Node(grid[x][y] == 1, true, null, null, null, null);
    }
}