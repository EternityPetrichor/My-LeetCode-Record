package Hot100.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class T739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }

    /*单调栈*/
    public static int[] dailyTemperatures(int[] temperatures){
        int[] answer = new int[temperatures.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            int curTemp = temperatures[i];
            while (!deque.isEmpty()&&curTemp>temperatures[deque.peek()]){
                int index = deque.pop();
                answer[index] = i - index;
            }
            deque.push(i);

        }
        return answer;
    }

    /*暴力，时间不通过*/
    public static int[] dailyTemperatures1(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        int day = 0;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int curTemp = temperatures[i];
            day = 0;
            boolean flag = false;
            if (curTemp<max){
                for (int j = i+1; j < temperatures.length; j++) {
                    day++;
                    if (temperatures[j]>curTemp){
                        result[i] = day;
                        flag = true;
                        break;
                    }
                }
            }

            if (!flag){
                result[i] = 0;
                max = curTemp;
            }

        }
        return result;
    }
}
