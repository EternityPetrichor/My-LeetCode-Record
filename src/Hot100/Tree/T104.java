package Hot100.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class T104 {

    /*深度优先计算深度*/
    public int maxDepth(TreeNode root){
        if (root == null)
            return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /*广度优先计算深度*/
    public int maxDepth1(TreeNode root){
        if (root == null)
            return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                size--;
            }
            depth++;
        }
        return depth;
    }

}
