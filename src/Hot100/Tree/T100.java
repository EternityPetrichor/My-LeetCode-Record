package Hot100.Tree;

public class T100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static TreeNode cloneTree(TreeNode root){
        if (root == null)
            return null;
        TreeNode node = new TreeNode(root.val);
        node.left = cloneTree(root.left);
        node.right = cloneTree(root.right);
        return node;
    }
}
