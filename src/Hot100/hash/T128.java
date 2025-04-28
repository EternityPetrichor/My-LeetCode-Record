package Hot100.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T128 {
    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive1(nums));
        int[] n1 = new int[]{1,2,0,1};
        System.out.println(longestConsecutive1(n1));
    }


    //以下是自己写的，时间复杂度不符合O（n），因为用到了排序
    public static int longestConsecutive(int[] nums) {
        if (nums.length==0)
            return 0;
        Arrays.sort(nums);
        int point = 1;
        int max = 1;
        int current = 1;
        while (point < nums.length){
            if (nums[point] == nums[point-1] + 1){
                current++;
                max = Math.max(max, current);
            } else if (nums[point] == nums[point - 1]) {
                point++;
                continue;
            } else {
                current = 1;
            }
            point++;
        }

        return max;
    }

    public static int longestConsecutive1(int[] nums){
        Set<Integer> set_nums = new HashSet<>();
        int max = 0;
        for (int n : nums)
            set_nums.add(n);
        for (int num : set_nums){
            if (!set_nums.contains(num-1)){
                int current_num = num;
                int current_length = 1;
                while (set_nums.contains(current_num+1)){
                    current_length++;
                    current_num++;
                }
                max = Math.max(current_length, max);
            }

        }
        return max;
    }
}
