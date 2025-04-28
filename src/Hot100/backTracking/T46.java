package Hot100.backTracking;

import java.util.ArrayList;
import java.util.List;

public class T46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracing(result, curList, nums, used);
        return result;
    }

    public static void backTracing(List<List<Integer>> result, List<Integer> curList, int[] nums, boolean[] used){
        if (curList.size() == nums.length){
            List<Integer> tempList = List.copyOf(curList);
            result.add(tempList);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            curList.add(nums[i]);
            used[i] = true;
            backTracing(result, curList, nums, used);
            used[i] = false;
            curList.removeLast();
        }
    }
}
