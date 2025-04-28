package Hot100.backTracking;

import java.util.*;

public class T47 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,2,1}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(result, curList, used, nums);
        return result;
    }
    public static void backTracking(List<List<Integer>> result, List<Integer> curList, boolean[] used, int[] nums){
        if (curList.size() == nums.length){
            List<Integer> tempList = List.copyOf(curList);
            result.add(tempList);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1] && !used[i-1])
                continue;
            if (!used[i]){
                curList.add(nums[i]);
                used[i] = true;
                backTracking(result, curList, used, nums);
                used[i] = false;
                curList.removeLast();
            }
        }
    }

    /*public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result;
        List<Integer> curList = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        boolean[] used = new boolean[nums.length];
        backTracking(set, curList, used, nums);
        result = set.stream().toList();
        return result;
    }

    public static void backTracking(Set<List<Integer>> set, List<Integer> curList, boolean[] used, int[] nums){
        if (curList.size() == nums.length){
            List<Integer> tempList = List.copyOf(curList);
            set.add(tempList);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            curList.add(nums[i]);
            used[i] = true;
            backTracking(set, curList, used, nums);
            curList.removeLast();
            used[i] = false;
        }
    }*/
}
