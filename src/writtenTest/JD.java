package writtenTest;

import java.util.*;

public class JD {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            String result = t1(s, m);
            System.out.println(result);
        }
    }

    public static String t1(String s, int m){
        char[] chars = s.toCharArray();
        int n = chars.length;
        int k = n-m;
        Deque<Character> deque = new LinkedList<>();
        int size = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (m>0 && result.length()>0&& chars[i]<result.charAt(result.length()-1)){
                result.deleteCharAt(result.length()-1);
                m--;
            }
            result.append(chars[i]);
        }
        while (m>0){
            result.deleteCharAt(result.length()-1);
            m--;
        }
        *//*for (int i = 0; i < n; i++) {
            while (size > 0 && m>0 && chars[i] < chars[size-1]){
                size--;
                m--;
            }
            if (size<k){
                size++;
                result += chars[i];
            }
        }*//*
        return result.toString();
    }*/

   /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(1);
        }
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int c = scanner.nextInt();
            scanner.nextLine();
            int shortTime = queue.poll();
            System.out.println(shortTime);
            queue.add(shortTime+c);
        }
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] h1 = new int[n];
        int[] h2 = new int[n];
        for (int i = 0; i < n; i++) {
            h1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            h2[i] = scanner.nextInt();
        }

        System.out.println(t3(n, h1, h2));
    }

    public static int t3(int n, int[] h1, int[] h2){
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 0; i < n - 1; i++) {
            dp[i+1][0] = Math.min(dp[i+1][0], dp[i][0]+Math.abs(h1[i+1]-h1[i]));
            dp[i+1][1] = Math.min(dp[i+1][1], dp[i][1]+Math.abs(h2[i+1]-h2[i]));
            dp[i][1] = Math.min(dp[i][1], dp[i][0] + 2 * Math.abs(h1[i] - h2[i]));
            dp[i][0] = Math.min(dp[i][0], dp[i][1] + 2 * Math.abs(h2[i] - h1[i]));
            dp[i+1][1] = Math.min(dp[i+1][1], dp[i][0] + 3 * Math.abs(h1[i] - h2[i+1]));
            dp[i+1][0] = Math.min(dp[i+1][0], dp[i][1] + 3 * Math.abs(h2[i] - h1[i+1]));
        }

        return Math.min(dp[n-1][0], dp[n-1][1]);
    }


}
