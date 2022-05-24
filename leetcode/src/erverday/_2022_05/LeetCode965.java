package erverday._2022_05;

/**
 * @author Csy
 * @Classname LeetCode965
 * @date 2022-05-24 21:18
 * @Description TODO
 */
public class LeetCode965 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.val) && dfs(root.right, root.val);
    }

    private boolean dfs(TreeNode node, int preVal) {
        if (node != null) {
            if (node.val != preVal) return false;
            return dfs(node.left, node.val) && dfs(node.right, node.val);
        }
        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
