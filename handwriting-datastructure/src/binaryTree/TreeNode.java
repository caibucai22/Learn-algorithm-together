package binaryTree;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname TreeNode
 * @date 2021-10-17 20:16
 * @Description TODO
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public static void createBiTree(TreeNode root){
        int val = new Scanner(System.in).nextInt();
        if(val == -1){
            root = null;
        }else{
            root= new TreeNode();
            root.val = val;
            createBiTree(root.left);
            createBiTree(root.right);
        }

    }

    public static void inOrderTraverse(TreeNode root){
        if(root != null){
            inOrderTraverse(root.left);
            System.out.print(root.val+" ");
            inOrderTraverse(root.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        createBiTree(root);
        inOrderTraverse(root);
    }
}
