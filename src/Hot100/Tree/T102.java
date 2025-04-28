package Hot100.Tree;

import java.util.*;

public class T102 {
    public static void main(String[] args) {
        System.out.println();
    }

    /*二叉树的层序遍历*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                size--;
            }
            result.add(list);
        }

        return result;
    }


    /*深度递归*/
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {return results;}
        Map<Integer, List<Integer>> map = new HashMap<>();
        helper(root, 0, map);
        return new ArrayList(map.values());
    }

    public void helper(TreeNode root, Integer level, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return ;
        }
        if (map.get(level) == null) {
            map.put(level, new ArrayList<Integer>());
        }
        List<Integer> list = map.get(level);
        list.add(root.val);

        helper(root.left, level + 1, map);
        helper(root.right, level + 1, map);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {

        if (root == null)
            return new ArrayList<>();
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        helper1(levelMap, root, 1);

        return new ArrayList<>(levelMap.values());
    }

    public void helper1(Map<Integer, List<Integer>> levelMap, TreeNode root, int level){
        if (root == null)
            return;

        if (!levelMap.containsKey(level))
            levelMap.put(level, new ArrayList<>());
        levelMap.get(level).add(root.val);
        helper1(levelMap, root.left, level+1);
        helper1(levelMap, root.right, level+1);

    }
}
