package Hot100.backTracking;

import java.util.*;
import java.util.stream.Collectors;

public class T216 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3,7));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        backTracking(result, curList, 0, k, n, nums);

        return result;
    }

    public static void backTracking(List<List<Integer>> result, List<Integer> curList, int startIndex, int k, int n, int[] nums){
        if (curList.size()>k || listToSum(curList)>n)
            return;
        if (curList.size() == k && listToSum(curList) == n){
            result.add(List.copyOf(curList));
            return;
        }

        for (int i = startIndex; i < nums.length-k; i++) {
            curList.add(nums[i]);
            backTracking(result, curList, i+1, k, n, nums);
            curList.removeLast();
        }
    }

    /*public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        boolean[] used = new boolean[9];
        Arrays.fill(used, false);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        Set<Set<Integer>> set = new HashSet<>();
        backTracking(result, curList, k, n, nums, used, set);

        return result;
    }

    public static void backTracking(List<List<Integer>> result, List<Integer> curList, int k, int n, int[] nums, boolean[] used, Set<Set<Integer>> set){
        if (curList.size() >k || listToSum(curList)>n)
            return;
        if (curList.size() == k && listToSum(curList)==n){
            List<Integer> tempList = List.copyOf(curList);
            Set<Integer> collect = new HashSet<>(tempList);
            if (!set.contains(collect)){
                set.add(collect);
                result.add(tempList);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            curList.add(nums[i]);
            used[i] = true;
            backTracking(result, curList, k, n, nums, used, set);
            used[i] = false;
            curList.removeLast();
        }
    }*/

    public static int listToSum(List<Integer> cur){
        int sum = 0;
        for (Integer i : cur)
            sum += i;

        return sum;
    }
}
