package Hot100.DP;

import java.util.ArrayList;
import java.util.List;

public class T118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        Integer[][] dp = new Integer[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                cur.add(dp[i][j]);
            }
            result.add(cur);
        }

        return result;
    }
}
