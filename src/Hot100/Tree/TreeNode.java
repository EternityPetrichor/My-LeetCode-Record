package Hot100.Tree;

public class TreeNode implements Cloneable{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        TreeNode clonedNode = (TreeNode) super.clone();
        // 深拷贝左子树
        if (this.left != null) {
            clonedNode.left = (TreeNode) this.left.clone();
        }
        // 深拷贝右子树
        if (this.right != null) {
            clonedNode.right = (TreeNode) this.right.clone();
        }
        return clonedNode;
    }
}
