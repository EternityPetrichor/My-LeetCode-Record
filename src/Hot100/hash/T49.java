package Hot100.hash;

import java.util.*;

public class T49 {
    public static void main(String[] args) {
        String[] str = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = Arrays.toString(chars);
            if (!map.containsKey(s)) {
                int resultIndex = result.size();
                map.put(s, resultIndex);
                List<String> s1 = new ArrayList<>();
                s1.add(str);
                result.add(resultIndex, s1);
            } else {
                int resultIndex = map.get(s);
                result.get(resultIndex).add(str);
            }
        }

        return result;
    }
}
