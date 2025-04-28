package Hot100.array;

public class T53 {
    public static void main(String[] args) {
        System.out.println();
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int sum = 0;
        int result = 0;
        int cur = 0;
        for (int i = cur; i < nums.length; i++) {
            for (int j = cur; j < nums.length; j++) {
                sum += nums[j];
                if (sum < 0){
                    break;
                }

            }
            result = Math.max(result, sum);
            sum = 0;
            cur++;
        }


        return result;
    }
}
