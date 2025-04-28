package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T239 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k){
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < k; i++){
            if (nums[i] >= max){
                max = nums[i];
                maxIndex = i;
            }
        }
        list.add(max);
        for (int i = k; i < nums.length; i++) {
            if (maxIndex < i - k + 1){
                if (nums[i] >= max){
                    max = nums[i];
                    maxIndex = i;
                    list.add(max);
                } else {
                    max = nums[maxIndex + 1];
                    for (int j = maxIndex + 1; j <= i; j++) {
                        if (nums[j] >= max){
                            max = nums[j];
                            maxIndex = j;
                        }
                    }
                    list.add(max);
                }

            } else {
                if (nums[i] >= max){
                    max = nums[i];
                    maxIndex = i;
                }
                list.add(max);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = list.get(i);

        return result;
    }

    /*暴力双循环，时间过不了*/
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        boolean flag = false;
        for (int i = 0; i < nums.length-k+1; i++) {
            int max = nums[i];
            for (int j = i+1; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result.add(max);
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return  res;
    }
}
