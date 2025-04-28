package Hot100.DP;

import java.util.List;
import java.util.Set;

public class T139 {
    public static void main(String[] args) {
        System.out.println("单词拆分");
        System.out.println(wordBreak("a", List.of("a")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = Set.copyOf(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = false;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && set.contains(s.substring(j, i + 1))) {
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
