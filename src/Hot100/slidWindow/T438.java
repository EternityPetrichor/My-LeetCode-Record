package Hot100.slidWindow;

import java.util.*;

public class T438 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        List<Integer> list = findAnagrams1(s, p);
        System.out.println(list);
    }

    public static List<Integer> findAnagrams1(String s, String p){
        char[] chars = p.toCharArray();
        List<Integer> indexList = new ArrayList<>();
        Map<Character, Integer> originMap = new HashMap<>();
        char[] chars1 = s.toCharArray();
        int left , right;
        for (left = 0; left<chars1.length; left++){
            generateMap(originMap, chars);
            for (right = left; right<chars1.length; right++){
                if (originMap.containsKey(chars1[right])){
                    originMap.put(chars1[right], originMap.get(chars1[right])-1);
                    if (originMap.get(chars1[right])==0)
                        originMap.remove(chars1[right]);
                } else {
                    break;
                }
            }
            if (originMap.isEmpty())
                indexList.add(left);
            originMap.clear();
        }
        return indexList;
    }

    public static void generateMap(Map<Character, Integer> originMap, char[] chars){
        for (char c : chars){
            originMap.put(c, originMap.getOrDefault(c, 0) + 1);
        }
    }
}
