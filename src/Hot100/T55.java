package Hot100;

public class T55 {
    public static void main(String[] args) {

        /*
        * 问题描述：
            给定一个非负整数数组 nums，其中 nums[i] 表示从下标 i 位置上
*           可以跳跃的最大步数。你需要判断是否能从数组的起始位置（下标 0）
*           跳跃到数组的最后一个位置（下标 nums.length - 1）。*/
    }

    public static boolean canJump(int[] nums){
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest)
                return false;
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1)
                return true;

        }

        return false;
    }

    /*
    * bool canJump(vector<int>& nums) {
        int step = 1;  // 走到目标需要的步数
        for (int i = nums.size() - 2; i >= 0; i--) {
            if (nums[i] >= step) {
            // 如果>=，代表从此元素可以达到
                step = 0;
            }
            step++;
        }
        return step == 1;
    }*/
}
