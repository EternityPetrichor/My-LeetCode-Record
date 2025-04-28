package Hot100.array;

import java.util.*;
import java.util.stream.Collectors;

public class T347 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 2, 2, 3, 3}, 2)));
    }


    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int code = Integer.compare(o2.getValue(), o1.getValue());
                if (code == 0)
                    return Integer.compare(o2.getKey(), o1.getKey());
                return code;
            }
        });
        priorityQueue.addAll(map.entrySet());
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().getKey();
        }

        return result;
    }
    /*public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);

        List<Map.Entry<Integer, Integer>> collect = map.entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    int code = Integer.compare(o2.getValue(), o1.getValue());
                    if (code==0)
                        return Integer.compare(o2.getKey(), o1.getKey());
                    return code;
                })
                .limit(k)
                .toList();
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = collect.get(i).getKey();
        }

        return result;
    }*/
}
