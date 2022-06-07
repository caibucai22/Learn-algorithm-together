package erverday._2022_06;

/**
 * @author Csy
 * @Classname LeetCode450
 * @date 2022-06-07 17:02
 * @Description TODO
 */
public class LeetCode450 {
}

class Solution450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        // 二叉搜索树 删除后 要进行更新
        // 重点是更新
        if (root == null) return null;

        // 删除节点在左子树
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else { // 根结点 为删除节点
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                // 左右子树都在 返回后继节点(右子树最左叶子) 作为新的根
                TreeNode successor = min(root.right);
                successor.right = deleteMin(root.right);
                successor.left = root.left;
                return successor;
            }
        }
    }

    // 一直向左下深搜
    private TreeNode min(TreeNode node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    // 删除被选中的左下节点 并返回根节点作为右子树
    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
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