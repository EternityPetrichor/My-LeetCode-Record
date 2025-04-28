package sortAlgorithm.normal;

import java.util.Arrays;
import java.util.Collections;

//直接插入排序(稳定)
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 6, 4, 5, 9, 7, 1, 8};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums){
        int temp;
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            temp = nums[i];
            while (j>0 && nums[j-1] > temp){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
    }

    public static void sort1(int[] nums){
        int temp;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];
            int j = Arrays.binarySearch(nums, 0, i-1, temp)+1;
            for (int k = i; k > j; k--) {
                nums[k] = nums[k-1];
            }
            nums[j] = temp;
        }
    }
}
