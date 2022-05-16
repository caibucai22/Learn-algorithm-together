import java.util.ArrayList;
import java.util.List;

/**
 * @author Csy
 * @Classname LeetCode0406
 * @date 2022-05-16 15:52
 * @Description TODO
 */
public class LeetCode0406 {

}

class Solution0406 {
    List<Integer> list = new ArrayList<>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == p.val) {
                return new TreeNode(list.get(i + 1));
            }
        }
        return null;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}