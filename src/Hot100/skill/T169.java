package Hot100.skill;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T169 {

    /*Boyer-Moore 算法*/
    /*O(n)时间，O(1)空间*//*“同归于尽消杀法”*/
    public int majorityElement3(int[] nums){
        int count = 0;
        int target = Integer.MIN_VALUE;
        for (int i : nums){
            if (count == 0){
                target = i;
                count++;
            } else if (i != target)
                count--;
            else count++;
        }
        return target;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int count = 1;
        int majority = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] == nums[i])
                count++;
            else count = 1;
            if (count > length / 2)
                majority = nums[i];
        }
        return majority;
    }

    public int majorityElement2(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int majority = 0;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > length / 2) {
                majority = n;
                break;
            }
        }
        return majority;
    }


}
