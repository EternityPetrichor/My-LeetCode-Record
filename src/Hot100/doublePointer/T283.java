package Hot100.doublePointer;

public class T283 {
    /*自己的解法*/
    /*public void moveZeros(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j]!=0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }*/

    /*官方题解*/
    public void moveZeros(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
