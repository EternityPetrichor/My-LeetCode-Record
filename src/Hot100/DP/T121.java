package Hot100.DP;

public class T121 {
    public static void main(String[] args) {
        System.out.println();
    }



    public int maxProfit1(int[] prices) {
        if (prices.length == 1)
            return 0;
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i]-minPrice);
            minPrice = Math.min(prices[i], minPrice);
        }
        return profit;
    }


    /*dp[i][0]第i天持有股票的最大消耗(切记在dp【i】【0】中我们永远持有这只股票,只是持有所花费的消耗不一样)
    dp[i][1]第i天不持有股票的最大获利金额(在dp【i】【1】中我们永远卖出了这只股票,只是卖出所获得的金额不一样)
* dp[i][0] = Math.min(dp[i-1][0], prices[i]);持有消耗求最小
* dp[i][1] = Math.max(dp[i-1][1],prices[i] - dp[i-1][0]);卖出获利家最多
*/
    public static int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
//            之前买入的消耗/今天买入的消耗
//            求持有股票的消耗求最小
            dp[i][0] = Math.min(dp[i - 1][0], prices[i]);
//            昨天卖出获得的金额今天卖出获得的金额(今天股票的价格-昨天持有服票的消耗)
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] - dp[i - 1][0]);

        }
        return dp[prices.length - 1][1];
    }

    /*暴力，时间不通过*/
    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;
        int maxPrice = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                maxPrice = Integer.max(maxPrice, prices[i] - prices[j]);
            }
        }
        return maxPrice;
    }
}
