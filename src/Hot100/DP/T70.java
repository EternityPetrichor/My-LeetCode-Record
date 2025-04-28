package Hot100.DP;

import java.util.Scanner;

public class T70 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
