package sortAlgorithm.normal;

import java.util.Arrays;
//冒泡排序（稳定）
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 6, 4, 5, 9, 7, 1, 8};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
//如果大小相同的两个元素在排序前后的先后顺序不变，改排序就是稳定的
    public static void sort(int[] nums){
        int temp;
        for (int i = 0; i < nums.length-1; i++) {
            boolean flag = true;//这里用一个标志来优化算法
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]){
                    flag = false;//如果发生交换，说明暂时还是无序的
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
            if (flag)//如果没有发生交换，说明已经是冒泡排序的形状了~~
                break;
        }
    }
}
