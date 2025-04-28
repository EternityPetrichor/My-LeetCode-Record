package Hot100.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T230 {
    public static void main(String[] args) {
        System.out.println("给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。");
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k-1);
    }

    public static void inOrder(TreeNode root, List<Integer> list){
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);

    }

    public static int kthSmallest1(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()){
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            k--;
            if (k==0)
                break;
            root = root.right;
        }
        return root.val;
    }

}
