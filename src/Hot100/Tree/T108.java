package Hot100.Tree;

public class T108 {
    public static void main(String[] args) {
        System.out.println();
    }

    /*一个整数数组，元素已经按升序排列*/
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return sorted(nums, 0, nums.length-1);
    }

    public TreeNode sorted(int[] nums, int left, int right){
        if (left > right)
            return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sorted(nums, left, mid-1);
        root.right = sorted(nums, mid+1, right);

        return root;
    }
}
