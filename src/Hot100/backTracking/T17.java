package Hot100.backTracking;

import java.util.ArrayList;
import java.util.List;

public class T17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        StringBuilder curStr = new StringBuilder();
        String[] letterMap = new String[]{
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backTracking(result, curStr, digits, letterMap, 0);
        return result;
    }

    public static void backTracking(List<String> result, StringBuilder curStr, String digits, String[] letterMap, int index){
        if (curStr.length() == digits.length()){
            result.add(String.valueOf(curStr));
            return;
        }

        String letter = letterMap[Integer.parseInt(String.valueOf(digits.charAt(index)))];
        for (int i = 0; i < letter.length(); i++) {
            curStr.append(letter.charAt(i));
            backTracking(result, curStr, digits, letterMap, index+1);
            curStr.deleteCharAt(curStr.length()-1);
        }
    }
    /*public static List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>();
        String[] letterMap = new String[]{
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        String curStr = "";
        backTracing(result, curStr, 0, letterMap, chars);

        return result;
    }

    public static void backTracing(List<String> result, String curStr, int index, String[] letterMap, char[] chars){
        if (curStr.length() == chars.length){
            result.add(curStr);
            return;
        }
        int digit = chars[index] - '0';
        String letter = letterMap[digit];
        for (int i = 0; i < letter.length(); i++) {
            curStr += letter.substring(i, i+1);
            backTracing(result, curStr, index+1, letterMap, chars);
            curStr = curStr.substring(0, curStr.length() - 2);
        }


    }*/
}

