
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Csy
 * @Classname LeetCode1609
 * @date 2021-12-26 23:03
 * @Description TODO
 */
public class LeetCode1609 {

    public boolean isEvenOddTree(TreeNode root) {
        // 广度优先遍历
        if(null == root  || root.val%2 != 1){
            return false;
        }
        Deque<TreeNode> q = new LinkedList<>();
        int start = 0;
        q.add(root);
        //
        while(!q.isEmpty()){
            int n = q.size();
            List<TreeNode> layer = new ArrayList<>();
            start++;
            for(int i=0;i<n;i++){
                layer.add(q.poll());
            }
            // 判断
            TreeNode min = new TreeNode(Integer.MAX_VALUE);
            TreeNode max = new TreeNode(Integer.MIN_VALUE);
            if(start%2 == 0){ // 偶数
                // 全为偶数，且从小到大
                for(TreeNode node:layer){
                    if(node.val%2==0){
                        return false;
                    }else{
                        if(node.val<=max.val){
                            return false;
                        }else{
                            max.val = node.val;
                        }
                    }
                }
            }else{ // 奇数
                // 全为奇数，且从大到小
                for(TreeNode node:layer){
                    if(node.val%2==0){
                        return false;
                    }else{
                        if(node.val>=min.val){
                            return false;
                        }else{
                            min.val = node.val;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1609 solution = new LeetCode1609();

    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
        this.right = right;
    }
}
