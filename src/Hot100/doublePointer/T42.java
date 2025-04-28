package Hot100.doublePointer;

public class T42 {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height1 = new int[]{4,2,3};
        System.out.println(trap(height));
    }



    public static int trap(int[] height){
        if (height.length < 3)
            return 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int count = 0;
        while (left < right){
            if (height[left] < height[right]){
                if (leftMax < height[left]){
                    leftMax = height[left];
                } else {
                    count += leftMax - height[left];
                }
                left ++;
            } else {
                if (rightMax < height[right]){
                    rightMax = height[right];
                } else {
                    count += rightMax - height[right];
                }
                right --;
            }
        }
        return count;
    }
}
