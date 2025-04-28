package writtenTest;

import java.util.*;

public class YoKa {
    public static void main(String[] args){
        int[] coupon = {2,1,3,3,2};
        int[] days = {3,2,1,3,2};
        System.out.println(spend(coupon, days));
    }

    public static int[] GetLeast (int[] Watermelon, int n) {
        // write code here
        List<Integer> list = new ArrayList<>();
        for (int i : Watermelon)
            list.add(i);
        Collections.sort(list);
        int[] array = new int[n];
        if (list.size()>=n){
            for (int i = 0; i < n; i++) {
                array[i] = list.get(i);
            }
        }
        return array;
    }

    public static int spend (int[] coupon, int[] days) {
        // write code here
        int n = coupon.length;
        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                for (int k = 1; k <= Math.min(j, days[i - 1]); k++) {
                    if (i-k>=0){
                        dp[i][j] = Math.max(dp[i][j], dp[i-k][j-k] + coupon[i-1]);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, dp[n][i]);
        }
        return max;

    }

    public int RestoreIp (String Ip) {
        // write code here
        List<String> results = new ArrayList<>();
        process(results, Ip, "", 0);
        return results.size();
    }

    public static void process(List<String> results, String reStr, String currentStr, int count){
        if (count == 3 && isValid(reStr)){
            results.add(currentStr + reStr);
            return;
        }

        for (int i = 1; i < Math.min(4, reStr.length()); i++) {
            String part = reStr.substring(0, i);
            if (isValid(part)){
                process(results, reStr.substring(i), currentStr+part+".", count+1);
            }
        }
    }

    public static boolean isValid(String s){
        if (s.length() > 1 && s.charAt(0) == '0')
            return false;
        int number = Integer.parseInt(s);
        return number>=0 && number<=255;
    }

}
