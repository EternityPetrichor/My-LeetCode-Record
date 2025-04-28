package writtenTest;

import java.util.Arrays;
import java.util.Scanner;

public class Test360 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T>0){
            String s = sc.nextLine();
            if(isHeFa(s))
                System.out.println("Yes");
            else
                System.out.println("No");

            T--;
        }
    }

    public static boolean isHeFa(String s){
        if(!isStructure(s))
            return false;
        return !isEquals(s);
    }
    public static boolean isStructure(String s){
        char[] chars = s.toCharArray();
        if (!((chars[0]>'0'&&chars[0]<'9') && (chars[chars.length-1]>'0' && chars[chars.length-1]<'9')))
            return false;
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i]=='0' && (chars[i+1]>'0' && chars[i+1]<'9'))
                return false;
            if ((!(chars[i]>'0' && chars[i]<'9')) && (!(chars[i+1]>'0' && chars[i+1]<'9')))
                return false;
        }
        return true;
    }
    public static boolean isEquals(String s){
        String[] splitDengHao = s.split("=");
        String left = splitDengHao[0];
        String right = splitDengHao[1];
        String[] splitLeftJiaHao = left.split("/+");
        String[] splitRightJiaHao = right.split("/+");
        int countLeftMulti = 1, countRightMulti = 1;
        int countLeftAdd = 0, countRightAdd = 0;
        for (int i = 0; i < splitLeftJiaHao.length; i++) {
            String[] split = splitLeftJiaHao[i].split("/*");
            if (split.length!=1){
                for (int j = 0; j < split.length; j++) {
                    countLeftMulti *= Integer.parseInt(split[i]);
                }
                countLeftAdd += countLeftMulti;
                countLeftMulti = 1;
            }
        }
        for (int i = 0; i < splitRightJiaHao.length; i++) {
            String[] split = splitRightJiaHao[i].split("/*");
            if (split.length!=1){
                for (int j = 0; j < split.length; j++) {
                    countRightMulti *= Integer.parseInt(split[i]);
                }
                countRightAdd += countRightMulti;
                countRightMulti = 1;
            }
        }
        if (countLeftAdd==countRightAdd)
            return true;
        String leftStr = String.valueOf(countLeftAdd);
        String rightStr = String.valueOf(countRightAdd);
        int min = Math.min(countLeftAdd, countRightAdd);
        String minStr = String.valueOf(min);
        int max = Math.max(countLeftAdd, countRightAdd);
        String maxStr = String.valueOf(max);
        if (!maxStr.contains(minStr))
            return false;

        return true;
    }

}
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        System.out.println(maxAcceptable(n, m, scanner));
//    }
//
//    public static int maxAcceptable(int n, int m, Scanner scanner){
//        int[][] consumer = new int[n][2];
//        int i = 0;
//        while (scanner.hasNextLine()){
//            consumer[i][0] = scanner.nextInt();
//            consumer[i][1] = scanner.nextInt();
//            i++;
//        }
//        System.out.println(Arrays.deepToString(consumer));
//        return 0;
//    }