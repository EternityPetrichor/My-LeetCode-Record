package writtenTest;

import java.util.Arrays;

public class HZBank {
    public static void main(String[] args) {
        System.out.println(findMaxValue(5,1,new int[]{1,2,3,4,5}, new int[]{2,3,4,5,6}));
    }

    public int countRiskyDeal (int[] record, int x) {
        // write code here
        int count = 0;
        int left = 0;
        int right = 1;
        while (right<record.length){
            if (record[left]<x){
                left ++;
                right = left + 1;
            }
            else {
                if (record[right]>=x){
                    right++;
                }

                else {
                    count += right-left==1?0:right-left;
                    left = right;
                    right = left+1;
                }
            }
        }
        count += right-left==1?0:right-left;
        return count;
    }

    public static int findMaxValue (int n, int k, int[] c, int[] v) {
        // write code here
        int maxCost = 0;
        if (Arrays.stream(c).max().isPresent())
            maxCost = k* Arrays.stream(c).max().getAsInt();
        int[][] dp = new int[k+1][maxCost+1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= maxCost; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= maxCost; j++) {
                for (int l = 0; l < n; l++) {
                    for (int m = 0; m <= i && m*c[l]<=j; m++) {
                        if (dp[i-m][j-m*c[l]]!=Integer.MIN_VALUE)
                            dp[i][j] = Math.max(dp[i][j], dp[i-m][j-m*c[l]]+m*v[l]);
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i <= maxCost; i++) {
            if (dp[k][i]>0d)
                result = Math.max(result, dp[k][i]/i);
        }
        return result;
    }
}
