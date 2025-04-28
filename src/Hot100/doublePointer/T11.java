package Hot100.doublePointer;

public class T11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int result = Integer.MIN_VALUE;

        while (left != right){
            int h = Math.min(height[left], height[right]);
            int area = h * (right - left);
            result = Math.max(result, area);
            if (height[left] < height[right])
                left ++;
            else right --;
        }

        return result;
    }

    public static int maxArea1(int[] height){
        return solve(height, 0, height.length - 1);
    }

    private static int solve(int[] height, int left, int right){
        if (left == right)
            return 0;
        int area = 0;
        area = (right - left) * Math.min(height[left], height[right]);
        return Math.max(area, height[left] < height[right] ? solve(height, ++left , right) : solve(height, left, --right));
    }
}
