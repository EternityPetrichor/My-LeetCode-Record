package Hot100.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class T101 {
    public static void main(String[] args) {
        System.out.println();
    }

    public boolean isSymmetric(TreeNode root) {
        TreeNode tree1 = root.left;
        TreeNode tree2 = root.right;
        return isEqual(tree1, tree2);
    }

    public boolean isEqual(TreeNode tree1, TreeNode tree2){
        if (tree1 == null && tree2 == null)
            return true;
        else if (tree1 == null)
            return false;
        else if (tree2 == null)
            return false;
        else if (tree1.val != tree2.val)
            return false;

        return isEqual(tree1.left, tree2.right) && isEqual(tree1.right, tree2.left);

    }


    public boolean isSymmetric1(TreeNode root) {
        TreeNode tree1 = root.left;
        TreeNode tree2 = T226.invertTree(T100.cloneTree(root)).left;
        return T100.isSameTree(tree1, tree2);
    }
}
