package Hot100;

import java.util.HashMap;
import java.util.Map;

public class T76 {
    public static void main(String[] args) {
        System.out.println(minWindow1("abccca", "bcc"));
    }

    public static String minWindow1(String s, String t){
        String result = "";
        String curStr = "";
        if (s.length() < t.length())
            return result;
        int left = 0, right = 0;
        Map<Character, Integer> baseMap = new HashMap<>();
        Map<Character, Integer> curMap = new HashMap<>();
        int size = Integer.MAX_VALUE;
        for (char c : t.toCharArray())
            baseMap.put(c, baseMap.getOrDefault(c, 0)+1);
        while (right < s.length()){
            if (baseMap.containsKey(s.charAt(right)))
                curMap.put(s.charAt(right), curMap.getOrDefault(s.charAt(right), 0)+1);
            while (check(baseMap, curMap)&&left<=right){
                if (right-left+1<size){
                    size = right-left+1;
                    result = s.substring(left, right+1);
                }
                Character c = s.charAt(left);
                if (curMap.containsKey(c))
                    curMap.put(c, curMap.get(c)-1);

                left++;
            }
            right++;
            /*String window = s.substring(left, right+1);
            curMap.put(s.charAt(right), curMap.getOrDefault(s.charAt(right), 0)+1);
            if (check(baseMap, curMap) && size>window.length()){
                result = window;
                size = window.length();
                if (curMap.get(s.charAt(left))==1)
                    curMap.remove(s.charAt(left));
                else curMap.put(s.charAt(left), curMap.get(s.charAt(left))-1);
                left++;
                if (curMap.containsKey(s.charAt(right)))
                    curMap.put(s.charAt(right), curMap.get(s.charAt(right))-1);

            }
            else {

                right++;
            }*/
        }

        return result;
    }

    public static boolean check(Map<Character, Integer> baseMap, Map<Character, Integer> curMap){
        for (Map.Entry<Character, Integer> entry : baseMap.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!curMap.containsKey(key) || curMap.get(key)<value)
                return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        String str = "";
        if (s.length() < t.length())
            return str;
        int start = 0, end = s.length();
        int newStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] tCharArray = t.toCharArray();
        char[] sCharArray = s.toCharArray();
        for (char c : tCharArray)
            map.put(c, map.getOrDefault(c, 0)+1);
        while (start < end){
            if (!map.containsKey(sCharArray[start])){
                start++;
                continue;
            }

        }
        return str;
    }
}
