package writtenTest;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Baidu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupNum = Integer.parseInt(scanner.nextLine());
        while (groupNum>0){
            int eatNum = 0;
            String[] split = scanner.nextLine().split(" ");
            int dataNum = Integer.parseInt(split[0]);
            int difference = Integer.parseInt(split[1]);
            List<Integer> list = new ArrayList<>();

            String[] dataStr = scanner.nextLine().split(" ");
            for (int i = 0; i < dataNum; i++) {
                list.add(Integer.parseInt(dataStr[i]));
            }

            Integer[] array = list.toArray(new Integer[0]);
            int left, right;
            for (left=0; left < array.length-1; left++) {
                List<Integer> eatList = new ArrayList<>();
                Deque<Integer> queue = new LinkedList<>();
                eatList.add(array[left]);
                queue.offer(array[left]);
                for (right=left+1; right < array.length; right++) {
                    if (Math.abs(array[right]- queue.element())<=difference){
                        eatList.add(array[right]);
                        queue.offer(array[right]);
                    }

                }
                eatNum = Math.max(eatNum, eatList.size());
            }

            System.out.println(eatNum);
            groupNum--;
        }

    }


    public static void T2() {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int n = Integer.parseInt(split[0]), k = Integer.parseInt(split[1]);
        String s = in.nextLine();
        for (int i = 0; i < k; i++) {
            s = Function(s);
        }
        System.out.println(s);
    }

    public static String Function(String s){
        s = reverse(s);
        s = deleteZero(s);
        return s;
    }

    public static String reverse(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='0')
                chars[i] = '1';
            else
                chars[i] = '0';
        }
        s = String.valueOf(chars);
        return s;
    }

    public static String deleteZero(String s){
        char[] chars = s.toCharArray();
        int index = s.indexOf("1");
        System.out.println(index);
        s = s.substring(index);
        return s;
    }

}
