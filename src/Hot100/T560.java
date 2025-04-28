package Hot100;

import java.util.HashMap;
import java.util.Map;

public class T560 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,0};
        int k = 0;
        System.out.println(subarraySum2(nums, k));
    }

    /*前缀和加哈希优化*/
    public static int subarraySum2(int[] nums, int k){
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k))
                count += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    /*枚举*/
    public static int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int left, right;
        int num = 0;
        int count;

        for (left = 0; left < length; left++) {
            count = 0;
            for (right = left; right < length; right++){
                count += nums[right];
                if (count == k)
                    num ++;
            }
        }

        return num;
    }

    public static int subarraySum1(int[] nums, int k){
        int length = nums.length;
        int num = 0;
        int count = 0, index = 0, start = 0;
        while (start != length){
            count += nums[index];
            if (count == k){
                num++;
                index++;
            }
            else index++;
            if (index == length){
                count = 0;
                start++;
                index = start;
            }
        }

        return num;
    }


}
