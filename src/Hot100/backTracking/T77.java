package Hot100.backTracking;

import java.util.ArrayList;
import java.util.List;

public class T77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        path(0, result, new ArrayList<>(), arr, k);
        return result;
    }

    public static void path(int start, List<List<Integer>> result, List<Integer> list, int[] arr, int k) {
        if (list.size() == k) {
            List<Integer> cur = new ArrayList<>(list);
            result.add(cur);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            list.add(arr[i]);
            path(i + 1, result, list, arr, k);
            list.removeLast();
        }
    }
}