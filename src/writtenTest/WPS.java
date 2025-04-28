package writtenTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WPS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int n1 = n;
        Set<Integer> set = new HashSet<>();
        while (n>0){
            set.add(n);
            n--;
        }
        int count =0;
        int flag = 0;
        int target = -1;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int t = in.nextInt();
            int x = in.nextInt();
            if (t==1&&flag==0){
                count++;
                set.remove(x);
            }
            else if (t==2&&flag==0){
                for (int i = 1; i <= n1; i++) {
                    if (i==x)
                        continue;
                    set.remove(i);
                }
                flag=1;
                count++;
                target = x;
            } else if (t==2 && x != target && flag == 1) {
                set.clear();
                count++;
            } else if (t==1 && x==target && flag==1){
                set.clear();
                count++;
            } else
                count++;

            if (set.isEmpty())
                break;
        }
        if (set.isEmpty())
            System.out.println(count);
        else System.out.println(-1);
    }
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int n1 = n;
        Set<Integer> set = new HashSet<>();
        int flag=0;
        while (n>0){
            set.add(n);
            n--;
        }
        int count =0;
        int target=-1;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int t = in.nextInt();
            int x = in.nextInt();
            if (t==1&&flag==0){
                count++;
                set.remove(x);
            }

            else if (t==2&&flag==0){
                if (set.contains(x)){
                    flag = 1;
                    target = x;
                }
                for (int i = 1; i <= n1; i++) {
                    if (i==x)
                        continue;
                    set.remove(i);
                }
                count++;

            } else {
                if (t==1&&x==target){
                    set.remove(x);
                    count++;
                    break;
                }else {
                    count++;
                    continue;
                }
            }

            if (set.isEmpty())
                break;
        }
        if (set.isEmpty())
            System.out.println(count);
        else System.out.println(-1);
    }*/
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] box = new int[n];
        for (int i : box)
            i = 0;
        int count =0;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int t = in.nextInt();
            int x = in.nextInt();
            doType(t,x, box);
            if(!isFull(box)){
                count++;
            }
        }
        System.out.print(count);
    }*/

    /*public static void doType(int t, int x, int[] box) {
        if (t == 1)
            TypeOne(x, box);
        else
            TypeTwo(x, box);
    }

    public static void TypeOne(int x, int[] box) {
        if (box[x-1] != 1)
            box[x-1] = 1;
    }

    public static void TypeTwo(int x, int[] box) {
        for (int i = 0; i < box.length; i++) {
            if (i == x-1)
                continue;
            if (box[i] != 1)
                box[i] = 1;
        }
    }

    public static boolean isFull(int[] box){
        for(int i : box){
            if(i==0){
                return false;
            }
        }
        return true;
    }*/

    public static int typeConversion(double d){

        //write your code here......
        String s = String.valueOf(d);
        String[] split = s.split("\\.");
        String s1 = String.valueOf(split[0]);
        return Integer.parseInt(s1);

    }


    /*T3 小美的蛋糕切割*/
    /*2 3
     1 1 4
    5 1 4*/
    /*把蛋糕像这样切开：
    1 1 | 4
    5 1 | 4
    左边蛋糕美味度之和是8
    右边蛋糕美味度之和是8
    所以答案是0。*/
}
