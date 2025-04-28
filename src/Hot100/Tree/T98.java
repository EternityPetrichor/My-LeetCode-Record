package Hot100.Tree;

import java.util.ArrayList;
import java.util.List;

public class T98 {
    public static void main(String[] args) {
        System.out.println("验证二叉搜索树");
    }

    /*方法2 二叉搜索树「中序遍历」得到的值构成的序列一定是升序的*/
    public static boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i+1)<= list.get(i))
                return false;
        }
        return true;
    }

    public static void inOrder(TreeNode root, List<Integer> list){
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }


    /*方法1，递归*/
    public static boolean isValidBST1(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean helper(TreeNode root, long minVal, long maxVal){
        if (root == null)
            return true;
        if (root.val <= minVal || root.val >= maxVal)
            return false;
        return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
    }
}
