package Hot100.DP;

public class T1235 {
    public static void main(String[] args) {
        System.out.println(jobScheduling(
                new int[]{1,2,3,3},
                new int[]{3,4,5,6},
                new int[]{50,10,40,70}
        ));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] dp = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1]);
            dp[i + 1][1] = Math.max(dp[i][0] + profit[i], dp[i][1]);
            for (int j = i - 1; j >= 0; j--) {
                if (endTime[j] <= startTime[i]) {
                    dp[i + 1][1] = Math.max(dp[j + 1][0] + profit[i], dp[i + 1][1]);
                    break;
                }
            }
        }
        return Math.max(dp[n][0], dp[n][1]);
    }
}
