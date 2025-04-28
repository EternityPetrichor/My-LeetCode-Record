package writtenTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MTuan {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(t1(s));
    }

    public static int t1(String s){
        int count = 0;
        if (s.length() <= 1)
            return count;
        Set<Character> set = new HashSet<>();
        set.add('A');
        set.add('H');
        set.add('I');
        set.add('M');
        set.add('O');
        set.add('T');
        set.add('U');
        set.add('V');
        set.add('W');
        set.add('X');
        set.add('Y');
        int left = 0;
        int right = 1;
        while (left<s.length()-1){
            if (set.contains(s.charAt(left)) && set.contains(s.charAt(right))){
                if (isHuiWen(s, left, right)){
                    count++;
                }
//                else right++;
                right++;
            } else {
                if (!set.contains(s.charAt(left))){
                    left++;
                    right = left+1;
                } else {
                    left = right+1;
                    right = left + 1;
                }
            }
            if (right == s.length()){
                left ++;
                right =left+1;
            }

        }
        return count;
    }

    public static boolean isHuiWen(String s, int left, int right){
        if (right-left==0)
            return false;
        String substring = s.substring(left, right + 1);
        int front = 0;
        int last = substring.length()-1;
        while (front < last){
            if (substring.charAt(front) != substring.charAt(last))
                return false;
            front++;
            last--;
        }
        System.out.println(substring);
        return true;
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t>0){
            int n = scanner.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = scanner.nextInt();
            }
            System.out.println(t2(num));
            t--;
        }
    }

    public static int t2(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((j-i)%2!=0)
                    continue;
                if (isGood(nums, i, j))
                    count++;
            }
        }
        return count;
    }

    public static boolean isGood(int[] nums, int start, int end){
        int[] ints = Arrays.copyOfRange(nums, start, end + 1);
        int zhongwei = nums[(start+end)/2];
        Arrays.sort(ints);
        return ints[(ints.length - 1) / 2] == zhongwei;

    }
}
