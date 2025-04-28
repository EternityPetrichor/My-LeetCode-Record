package writtenTest;

import java.util.*;

public class MeiTuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        String string = scanner.nextLine();
        List<Integer> list = new ArrayList<>();
        int currentNum = 0;
        boolean inNumber = false;
        for (char c : string.toCharArray()){
            if (Character.isDigit(c)){
                currentNum = currentNum*10 + Character.getNumericValue(c);
                inNumber = true;
            } else {
                if (inNumber){
                    list.add(currentNum);
                    inNumber=false;
                }
            }
        }
        if (inNumber){
            list.add(currentNum);
        }

        Collections.sort(list, Collections.reverseOrder());
        if (k<=0 || k>list.size()){
            System.out.println("N");
        } else {
            System.out.println(list.get(k-1));
        }
    }
}
