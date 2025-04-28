package Hot100.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class T394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[cb]]"));
    }

    /*递归*/
    public static String decodeString1(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()){
            if (c != ']')
                deque.push(c);
            else {

                //step1：取出[]中的字符串
                StringBuilder sb = new StringBuilder();
                while (!deque.isEmpty() && Character.isLetter(deque.peek()))
                    sb.insert(0, deque.pop());
                String sub = sb.toString();
                deque.pop();

                //step2：获取倍数数字
                sb = new StringBuilder();
                while (!deque.isEmpty() && Character.isDigit(deque.peek()))
                    sb.insert(0, deque.pop());
                int repeatTimes = Integer.parseInt(sb.toString());

                //step3：根据倍数把字母再push进去
                while (repeatTimes > 0){
                    for (char ch : sub.toCharArray())
                        deque.push(ch);
                    repeatTimes--;
                }

            }
        }

        //把栈里面的所有字母取出来
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty())
            result.insert(0, deque.pop());
        return result.toString();

    }

    public static String decodeString(String s) {
        Deque<String> stringDeque = new LinkedList<>();
        Deque<Integer> countDeque = new LinkedList<>();
        String currentStr = "";
        int k = 0;
        for (char c : s.toCharArray()){
            if (Character.isDigit(c))
                k = k * 10 + c - '0';
            else if (c == '[') {
                countDeque.push(k);
                stringDeque.push(currentStr);
                currentStr = "";
                k = 0;
            } else if (c == ']') {
                int repeatTimes = countDeque.pop();
                currentStr = stringDeque.pop() + currentStr.repeat(Math.max(0, repeatTimes));
            }
            else currentStr += c;
        }
        return currentStr;
    }
}
