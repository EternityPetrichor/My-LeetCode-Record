package Hot100.array;

import java.util.Arrays;

public class T26 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        int cur, pre;
        int count = 1;
        pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i];
            if (cur != pre){
                count++;
                nums[count-1] = cur;
            }
            pre = cur;
        }

        return count;
    }

    public static int removeDuplicates1(int[] nums) {
        int[] array = Arrays.stream(nums).distinct().toArray();
        for (int i = 0; i < array.length; i++) {
            nums[i] = array[i];
        }
        return array.length;
    }

    public static int removeDuplicates2(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast]!=nums[slow])
                nums[++slow] = nums[fast];
        }
        return ++slow;
    }
}
