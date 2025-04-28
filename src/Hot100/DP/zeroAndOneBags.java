package Hot100.DP;

import java.util.Scanner;

public class zeroAndOneBags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[] space = new int[M+1];
        int[] value = new int[M+1];
        for (int i = 1; i < M+1; i++) {
            space[i] = scanner.nextInt();
        }
        for (int i = 1; i < M+1; i++) {
            value[i] = scanner.nextInt();
        }

        int[][] dp = new int[M+1][N+1];

        for (int i = 1; i < M+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (space[i]<=N)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-space[i]]+value[i]);
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[M][N]);
    }

}
