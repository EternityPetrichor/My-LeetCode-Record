package Hot100.stack;

import java.util.*;

public class T496 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    /*时间复杂度O(m+n)*/
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> idx = new HashMap<>(n); // 预分配空间
        for (int i = 0; i < n; i++) {
            idx.put(nums1[i], i);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int x : nums2) {
            while (!st.isEmpty() && x > st.peek()) {
                // x 是栈顶的下一个更大元素
                // 既然栈顶已经算出答案，弹出
                ans[idx.get(st.pop())] = x; // 记录答案
            }
            if (idx.containsKey(x)) { // x 在 nums1 中
                st.push(x); // 只需把在 nums1 中的元素入栈
            }
        }
        return ans;
    }



    /*暴力解法*/
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            boolean flag = false;
            while (nums2[j] != nums1[i])
                j++;
            while (j< nums2.length){
                if (nums2[j]>nums1[i]){
                    flag = true;
                    break;
                }
                j++;
            }
            if (flag)
                answer[i] = nums2[j];
            else answer[i] = -1;
        }
        return answer;
    }
}
