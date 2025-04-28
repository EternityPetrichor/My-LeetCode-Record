package sortAlgorithm.advancedSort;

import java.util.Arrays;
import java.util.Random;

public class MonkeySort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 6, 4, 5, 9, 7, 1, 8};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums){
        Random random = new Random();
        int count = 0;
        while (!checkOrder(nums)){
            int a = random.nextInt(nums.length);
            int b = random.nextInt(nums.length);
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            count++;
        }
        System.out.println("共进行了"+count+"轮排序");
    }

    public static boolean checkOrder(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] < nums[i])
                return false;
        }
        return true;
    }
}
