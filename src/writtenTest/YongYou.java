package writtenTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YongYou {
//    /*public static void main(String[] args) {
//        System.out.println(Arrays.toString(favoriteSongs(new int[]{7, 3, 7, 2, 3, 4, 3, 7, 7, 1, 8, 4, 7, 4, 8}, 3)));
//    }
//
//    public static int[] favoriteSongs (int[] songs, int k) {
//        // write code here
//        int[] result = new int[k];
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int song : songs)
//            map.put(song, map.getOrDefault(song, 0)+1);
//        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream()
//                .sorted((o1, o2) -> {
//                    int result1 = Integer.compare(o2.getValue(), o1.getValue());
//                    if (result1 == 0)
//                        return Integer.compare(o2.getKey(), o1.getKey());
//                    return result1;
//                })
//                .limit(k)
//                .toList();
//        for (int i = 0; i < k; i++) {
//            result[i] = collect.get(i).getKey();
//        }
//        Arrays.sort(result);
//        *//*int[] result = new int[k];
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : songs){
//            map.put(i, map.getOrDefault(i, 0)+1);
//        }
//        for (int i = 0; i < k; i++) {
//            int id = 0;
//            int preMaxId = 0;
//            int count = 0;
//            for (Integer key : map.keySet()) {
//                id = key;
//                if (map.get(id)>count)
//                    preMaxId = id;
//                count = Math.max(count, map.get(id));
//            }
//            result[i] = preMaxId;
//            map.remove(preMaxId);
//        }
//        Arrays.sort(result);
//        return result;*//*
//        return result;
//    }*/


    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] cap = new int[m];
        for (int i = 0; i < m; i++) {
            cap[i] = scanner.nextInt();
        }
        int[][] activity = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                activity[i][j] = scanner.nextInt();
            }
        }
        System.out.println(t2(cap, activity));
    }

    public static boolean t2(int[] cap, int[][] activity){
        int[] ints = Arrays.copyOf(cap, cap.length);
        Arrays.sort(ints);
        for (int[] value : activity) {
            if (value[2] > ints[ints.length - 1])
                return false;
        }
        return true;
    }*/
    static int APrice = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Deque<Integer> priceQueue = new LinkedList<>();
        int totalPrice = 0;
        Deque<Integer> aDeque = new LinkedList<>();
        Deque<Integer> bDeque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt();
            priceQueue.add(price);
            totalPrice += price;
        }
        System.out.println(t3(priceQueue, totalPrice, aDeque,bDeque));
    }

    public static boolean t3(Deque<Integer> priceQueue, int totalPrice, Deque<Integer> aDeque, Deque<Integer> bDeque){
        search(priceQueue, aDeque, bDeque);
        return APrice > totalPrice / 2;
    }

    public static void search(Deque<Integer> priceQueue, Deque<Integer> aDeque, Deque<Integer> bDeque){
        if (priceQueue.isEmpty()){
            APrice = Math.max(APrice, sum(aDeque));
            return;
        }
        int left = priceQueue.pollFirst();
        aDeque.add(left);
        if (priceQueue.isEmpty()){
            APrice = Math.max(APrice, sum(aDeque));
            return;
        }
        int leftb = priceQueue.pollFirst();
        bDeque.add(leftb);
        search(priceQueue, aDeque, bDeque);
        priceQueue.add(leftb);
        if (priceQueue.isEmpty()){
            APrice = Math.max(APrice, sum(aDeque));
            return;
        }
        int rightb = priceQueue.pollLast();
        bDeque.add(rightb);
        priceQueue.add(rightb);
        priceQueue.add(left);

        if (priceQueue.isEmpty()){
            APrice = Math.max(APrice, sum(aDeque));
            return;
        }
        int right = priceQueue.pollLast();
        aDeque.add(right);
        if (priceQueue.isEmpty()){
            APrice = Math.max(APrice, sum(aDeque));
            return;
        }
        int leftb1 = priceQueue.pollFirst();
        bDeque.add(leftb1);
        search(priceQueue, aDeque, bDeque);
        priceQueue.add(leftb);
        if (priceQueue.isEmpty()){
            APrice = Math.max(APrice, sum(aDeque));
            return;
        }
        int rightb2 = priceQueue.pollLast();
        bDeque.add(rightb2);
        priceQueue.add(rightb);
        priceQueue.add(right);
    }

    public static int sum(Deque<Integer> aDeque){
        int sum = 0;
        Integer[] array = aDeque.toArray(new Integer[0]);
        for (int i : array)
            sum+=i;
        return sum;
    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] startTime = new int[n];
        int[] saleTime = new int[n];
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            startTime[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            saleTime[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            profit[i] = scanner.nextInt();
        }

        System.out.println(t4(profit, saleTime));
    }

    public static int t4(int[] profit, int[] saleTime){
        int[] dp= new int[profit.length+1];
        for (int i = 1; i < profit.length + 1; i++) {
            dp[i] = Math.max(dp[i-1], saleTime[i-1]<=2?dp[i-1]+profit[i]:dp[i-1]);
        }
        return dp[profit.length]+profit[profit.length-1];
    }*/
}
