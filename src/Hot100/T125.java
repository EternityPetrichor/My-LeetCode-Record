package Hot100;

import java.util.ArrayList;
import java.util.List;

public class T125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : chars){
            if (Character.isLetter(c)||Character.isDigit(c)){
                if (Character.isLetter(c))
                    c = Character.toLowerCase(c);
                list.add(c);
            }
        }
        int size = list.size();
        for (int i = 0; i < size/2; i++) {
            if (!list.get(i).equals(list.get(size-i-1)))
                return false;
        }

        return true;
    }
}
