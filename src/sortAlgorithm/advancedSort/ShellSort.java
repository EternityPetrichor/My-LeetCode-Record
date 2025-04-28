package sortAlgorithm.advancedSort;

import java.util.Arrays;

//希尔排序（插入排序的进阶）（不稳定）
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 6, 4, 5, 9, 7, 1, 8};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums){
        int delta = nums.length / 2;
        while (delta >= 1){
            for (int i = delta; i < nums.length; i++) {
                int j = i;
                int temp = nums[i];
                while (j >= delta && nums[j-delta] > temp){
                    nums[j] = nums[j-delta];
                    j -= delta;
                }
                nums[j] = temp;
            }
            delta /= 2;
        }
    }
}
