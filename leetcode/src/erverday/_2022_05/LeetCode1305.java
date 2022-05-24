package erverday._2022_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Csy
 * @Classname erverday._2022_05.LeetCode1305
 * @date 2022-05-01 16:26
 * @Description TODO
 */
public class LeetCode1305 {
    static class TreeNode {
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

    public static void main(String[] args) {

    }
}


class Solution1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ret = new ArrayList<>();
        dfs(root1, ret);
        dfs(root2, ret);
        Collections.sort(ret);
        return ret;
    }

    private void dfs(TreeNode root, List<Integer> ret) {
        if (root != null) {
            dfs(root.left, ret);
            ret.add(root.val);
            dfs(root.right, ret);
        }
    }
}
