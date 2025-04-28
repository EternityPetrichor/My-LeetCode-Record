package Hot100.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T94 {
    public static void main(String[] args) {
        System.out.println("中序遍历");
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> result){
        if (root == null)
            return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }


    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()){
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }



}
