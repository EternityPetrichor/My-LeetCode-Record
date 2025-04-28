package Hot100.Tree;

public class T543 {
    int maxDepth = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDepth;
    }

    public int depth(TreeNode root){
        if (root == null)
            return 0;
        int L = depth(root.left);
        int R = depth(root.right);
        maxDepth = Math.max(L + R, maxDepth);

        return Math.max(L, R) + 1;
    }
}
