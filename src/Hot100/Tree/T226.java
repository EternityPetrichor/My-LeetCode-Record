package Hot100.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class T226 {
    public static void main(String[] args) {
        System.out.println();
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode node = root.right;
        root.right = root.left;
        root.left = node;

        return root;
    }

    public static TreeNode invertTree1(TreeNode root){
        if (root == null)
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp = node.right;
            node.right = node.left;
            node.left = tmp;

            if (node.right != null)
                queue.offer(node.right);
            if (node.left != null)
                queue.offer(node.left);
        }
        return root;
    }
}
