package Hot100.doublePointer;

import java.util.*;

public class T15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    /*排序和双指针法*/
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            int left, right;
            left = i + 1;
            right = n - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1])
                        left++;
                    while (left < right && nums[right] == nums[right-1])
                        right--;

                    left++;
                    right--;
                }
                else if (sum < 0)
                    left++;
                else
                    right--;

            }
        }

        return result;

    }

    /*public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i]>0)
                break;
            if (i-1>=0 && nums[i]==nums[i-1])
                continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j-1>i&&nums[j-1]==nums[j])
                    continue;

                for (int k = j + 1; k < nums.length; k++) {
                    if (k-1>j&&nums[k-1]==nums[k])
                        continue;

                    if (nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list = List.of(nums[i], nums[j], nums[k]);
                        lists.add(list);
                        break;
                    }
                }
            }
        }
        return lists;
    }*/

    /*以下方法耗时又耗费空间*/
    /*public static List<List<Integer>> threeSum(int[] nums){
        Set<List<Integer>> set = new HashSet<>();
        int length = nums.length;

        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }*/

//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i]+nums[j]+nums[k] == 0 && isNotRepeatable(lists, nums[i], nums[j], nums[k])){
//                        List<Integer> list = List.of(nums[i], nums[j], nums[k]);
//                        lists.add(list);
//                    }
//
//                }
//            }
//        }
//        return lists;
//    }
//
//    public static boolean isNotRepeatable(List<List<Integer>> lists, int a, int b, int c){
//        for (List<Integer> l : lists){
//            int a0 = l.get(0);
//            int b0 = l.get(1);
//            int c0 = l.get(2);
//            if (a==a0){
//                if ((b==b0&&c==c0) || (b==c0&&c==b0))
//                    return false;
//            }
//            if (b==a0){
//                if ((a==b0&&c==c0) || (a==c0&&c==b0))
//                    return false;
//            }
//            if (c==a0){
//                if ((b==b0&&a==c0) || (b==c0&&a==b0))
//                    return false;
//            }
//        }
//        return true;
//    }
}
