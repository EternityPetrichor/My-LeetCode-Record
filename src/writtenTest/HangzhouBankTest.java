package writtenTest;

import java.util.*;
//找出出现次数最多的数据，次数相同以值小的为准
public class HangzhouBankTest {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,3,1,2,8,9,3,2};
        int test = test(arr);
        int test1 = test1(arr);
        System.out.println(test);
        System.out.println(test1);
    }
    public static int test(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            } else {
                map.put(j, map.get(j) + 1);
            }
        }
        int key = 100;
        int value = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int tempKey = entry.getKey();
            int tempValue = entry.getValue();
            if (tempValue>value || (tempValue == value && tempKey < key)){
                key = tempKey;
                value = tempValue;
            }
        }
        return key;
    }

    public static int test1(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            } else {
                map.put(j, map.get(j) + 1);
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Integer[] array = list.toArray(Integer[]::new);
        Collections.sort(list);
        int key = list.getFirst();
        int value = map.get(key);
        for (int l : list){
            if (map.get(l)>value){
                key = l;
                value = map.get(l);
            }
        }

        return key;
    }
}
