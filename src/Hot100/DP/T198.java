package Hot100.DP;

public class T198 {
    public static void main(String[] args) {

    }

    public static int rob1(int[] nums){
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[length-1];

    }

    public static int rob(int[] nums){
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];

    }

    public static int robT213(int[] nums){
        if (nums==null || nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        int length = nums.length;
        int[] dp1 = new int[length];
        int[] dp2 = new int[length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(dp1[0], nums[1]);
        dp2[1] = nums[1];
        for (int i = 2; i < length; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+nums[i]);
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+nums[i]);
        }
        return Math.max(dp1[length-2], dp2[length-1]);
    }

}
