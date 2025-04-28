package sortAlgorithm.advancedSort;

import java.util.Arrays;

//快速排序(冒泡排序的进阶)（不稳定）
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 6, 4, 5, 9, 7, 1, 8};
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums, int start, int end){
        if (start >= end)
            return;
        int left= start, right = end, pivot = nums[start];
        while (left<right){
            while (left<right && nums[right] > pivot)
                right--;
            nums[left] = nums[right];
            while (left<right && nums[left] < pivot)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        sort(nums, start, left-1);
        sort(nums, left+1, end);
    }
}
