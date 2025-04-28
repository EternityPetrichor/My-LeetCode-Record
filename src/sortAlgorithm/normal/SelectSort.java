package sortAlgorithm.normal;

import java.util.Arrays;

//直接选择排序(不稳定)
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 6, 4, 5, 9, 7, 1, 8};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums){
        int min;
        for (int i = 0; i < nums.length-1; i++) {
            min = i;
            for (int j = i+1; j < nums.length; j++) {   //挨个遍历剩余的元素，如果遇到比当前记录的最小元素还小的元素，就更新
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }
}
