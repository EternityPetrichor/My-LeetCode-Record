package writtenTest;

import java.util.*;
public class  ShanghaiBankTest{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个三位数:");
        int num = scanner.nextInt();
        System.out.println("有"+test(num)+"个三位素数之和的组合数");

    }

    public static int test(int num) {
        List<Integer> list = new ArrayList<>();
        generatePrime(num, list);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                for (int k = j; k < list.size(); k++) {
                    if (list.get(i)+ list.get(j)+ list.get(k)==num){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void generatePrime(int num, List<Integer> list){
        for (int i = 2; i < num; i++) {
            if(ifPrime(i)){
                list.add(i);
            }
        }
    }

    public static boolean ifPrime(int currentNum){
        for (int i = 2; i < currentNum; i++) {
            if (currentNum % i == 0)
                return false;
        }
        return true;
    }
}
