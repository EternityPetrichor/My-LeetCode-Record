package writtenTest;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManBang {
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }


        System.out.println(formatFloat(calcExpectation(a, b, arr)));
    }

    public static float calcExpectation(int a, int b, int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        System.out.println();
        float c1 = (float) map.get(a) / arr.length;
        float c2 = (float) map.get(b) / arr.length;
        return 1/(c1*c2);
    }

    public static float formatFloat(float c){
        String s = String.valueOf(c);
        String[] split = s.split("\\.");
        float zhengshu = Float.parseFloat(split[0]);
        String xiaoshu = split[1];
        char[] chars = xiaoshu.toCharArray();
        if (chars.length==1)
            return zhengshu + Float.parseFloat(xiaoshu);
        if (Integer.parseInt(String.valueOf(chars[1]))>=5)
            return (float) (zhengshu + Float.parseFloat(String.valueOf(chars[0]))*0.1+0.1);
        return (float) (zhengshu +Float.parseFloat(String.valueOf(chars[0]))*0.1);
    }*/


    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T>0){
            int e = in.nextInt();
            int end = 1;
            while (e>0){
                end*=10;
                e--;
            }
            System.out.println(count(end/10, end));
            T--;
        }
    }*/

    public static int count(int start, int end){
        int count = 0;
        for (int j = start; j < end; j++) {
            if (sumAndMulti(j))
                count ++;
        }
        return count;
    }

    public static boolean sumAndMulti(int num){
        int sum = 0;
        int multi = 1;
        while (num != 0){
            sum += num %10;
            multi *= num%10;
            num /= 10;
        }
        return sum % 7 == 0 && multi%7==0;
    }

    public static void main(String[] args) {
        float a = (float) (4/2.0);
        DecimalFormat decimalFormat = new DecimalFormat("0,000.0");
        System.out.println(decimalFormat.format(a));
    }



}
