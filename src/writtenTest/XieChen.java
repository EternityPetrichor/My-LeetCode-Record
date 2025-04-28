package writtenTest;

import java.util.*;

public class XieChen {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        /*String s = in.nextLine();
        String result = test1(s);
        System.out.println(result);*/

        /*int T = in.nextInt();
        List<Integer> result = new ArrayList<>();
        while (T>0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            result.add(test2(arr));
            T--;
        }
        for(int res : result)
            System.out.println(res);*/
        int[] arr = new int[]{1,2,2,5};
        Arrays.sort(arr);
        System.out.println(findThLargestNum(3, arr));

        /*int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(test3(a, k));*/
    }

    public static String test1(String s){
        String result = "";
        char[] chars = s.toCharArray();
        int length = chars.length;
        boolean flag = true;
        int start = 0;
        int step = 1;
        while (flag){
            if (start + step >= length){
                flag = false;
            }
            result += chars[start];
            start += step;
            step++;
        }

        return result;
    }

    public static int test2(int[] arr){//[2,2,3,4,5]
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            count = Math.max(count, arr[arr.length-1-i]+i+1);
        }
        return count;
    }
    public static int findThLargestNum(int n, int[] arr){
        int uniqueCount = 1; // 最后一个元素是第一个不同元素
        int current = arr[arr.length - 1];
        if (n == 1) {
            return current; // 直接返回最大值
        }

        // 从倒数第二个元素遍历到第一个元素（索引0）
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != current) {
                uniqueCount++;
                current = arr[i];
                if (uniqueCount == n) {
                    return current; // 找到第n大元素
                }
            }
        }

        // 遍历完仍未找到，说明n超过不同元素数量，返回最小值
        return arr[0];
    }

    public static int findThLargestNum1(int n, int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i = arr.length-1; i > 0; i--) {
            if (arr[i]!=arr[i-1])
                set.add(arr[i]);
            if (set.size() == n)
                return arr[i];
        }
        return arr[0];
    }


    public static int test3(int[] a, int k){
        int[] value = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            value[i] = calcCount(a[i]);
        }
        int selectNum = a.length - k;
        /*int[][] dp = new int[a.length][selectNum];
        for (int i = 0; i < selectNum; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < a.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], value[i]);
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < selectNum; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j-1]+value[i]);
            }
        }
        return dp[a.length-1][selectNum-1];*/
        int result = 0;
        int i = 0;
        Arrays.sort(value);
        while (selectNum>0){
            result+=value[value.length-i-1];
            i++;
            selectNum--;
        }
        return result;
    }

    public static List<Integer> getCount(int num){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < num + 1; i++) {
            if (num%i==0 && ifPrime(i))
                list.add(i);
        }

        return list;
    }
    public static boolean ifPrime(int num){
        if (num == 1)
            return false;
        for (int i = 2; i < num; i++) {
            if (num%i==0)
                return false;
        }
        return true;
    }

    public static int calcCount(int num){
        List<Integer> count = getCount(num);
        return count.size();
    }
}
