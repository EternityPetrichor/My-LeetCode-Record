package Hot100.DP;

import java.util.Arrays;

public class T322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{2,5,10,1},27));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins){
            for (int i = 1; i < amount+1; i++) {
                if (coin <= i && dp[i-coin]!=Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
