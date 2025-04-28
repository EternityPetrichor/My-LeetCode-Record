package writtenTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

public class PDD2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        while (t>0){
            /*int n = Integer.parseInt(in.nextLine());
            String s = in.nextLine();
            if (t1(n, s))
                System.out.println("lucky");
            else System.out.println("unlucky");*/
            int n = in.nextInt();
            int m = in.nextInt();
            int s1 = in.nextInt();
            int s2 = in.nextInt();
            System.out.println(t2(n, m, s1, s2));
            t--;
        }
    }

    public static boolean t1(int n, String s){
        if (n<9)
            return false;
        /*boolean flag = false;
        for (int i = 0; i < s.length() - 9; i++) {
            String temp = s.substring(i, i+9);
            if (temp.equals("111111111") && s.charAt(i + 9) == '0'){
                flag = true;
            } else if (temp.equals("111111111") && s.charAt(i + 9) == '1') {
                return false;
            }
        }
        return flag;*/

        char[] chars = s.toCharArray();
        int maxLength = 0;
        int length = 0;
        int pre = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1'){
                length++;
                maxLength = Math.max(maxLength, length);
                if (pre == 0)
                    pre = 1;

            }
            else {
                length = 0;
                pre = 0;
            }
        }
        return maxLength==9;
    }

    /*public static int t2(int n, int m, int s1, int s2){
        if (n>m)
            return -1;
        else if (n < m) {
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = s1%10;
                s1 = s1 / 10;
            }
            Arrays.sort(s);
            int sum = 0;
            for (int i = n-1; i >= 0; i--) {
                sum *= 10;
                sum += s[i];
            }
            return sum;
        }
        else {
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            for (int i = 0; i < n; i++) {
                arr1[i] = s1%10;
                s1 = s1 / 10;
            }
            for (int i = m-1; i >= 0; i--) {
                arr2[i] = s2%10;
                s2 = s2 / 10;
            }
            Arrays.sort(arr1);

            int sum = 0;
            int[] newArray = new int[m];
            boolean[] use = new boolean[m];
            Arrays.fill(use, true);
            if (arr1[0]>arr2[0])
                return -1;
            else if (arr1[n-1]<arr2[0]){
                for (int i = n-1; i >= 0; i--) {
                    sum *= 10;
                    sum += arr1[i];
                }
            }//1 1 5 7 8
            //5 1 7 2 1
            //5 1
            else {
                boolean flag = false;
                int d = 0;
                for (int i = 0; i < m; i++) {
                    if (ifIn(arr1, arr2[i]) && use[index(arr1, arr2[i])]){
                        newArray[i] = arr2[i];
                        use[index(arr1, arr2[i])] = false;
                    }
                    else {
                        int c = findSmaller(arr1, arr2[i], use);
                        if (c==-1)
                            return -1;
                        newArray[i] = arr1[c];
                        use[c] = false;
                        flag = true;
                        d = i;
                    }
                    if (flag)
                        break;
                }
                if (flag){
                    for (int i = d+1; i < m; i++) {
                        int g = findMax(arr1, use);
                        newArray[i] = arr1[g];
                        use[g] = false;
                    }
                }
                for (int i = 0; i < m; i++) {
                    sum*=10;
                    sum += newArray[i];
                }
            }
            return sum;
        }
    }*/
    public static int t2(int n, int m, int s1, int s2) {
        // 将数字转换为字符数组
        char[] num1 = String.valueOf(s1).toCharArray();
        char[] num2 = String.valueOf(s2).toCharArray();

        // 位数不同直接返回-1
        if (num1.length != num2.length) return -1;

        // 排序便于贪心
        Arrays.sort(num1);

        // 从最高位开始尝试构造最大数
        boolean tight = true;
        char[] res = new char[num1.length];
        boolean[] used = new boolean[num1.length];

        for (int i = 0; i < num1.length; i++) {
            // 在可用数字中找最大可能的候选
            char maxCandidate = tight ? num2[i] : '9';
            int chosen = -1;

            // 倒序遍历找最大的可用数字
            for (int j = num1.length-1; j >= 0; j--) {
                if (!used[j] && num1[j] <= maxCandidate) {
                    if (chosen == -1 || num1[j] > num1[chosen]) {
                        chosen = j;
                    }
                }
            }

            // 找不到合法数字
            if (chosen == -1) return -1;

            // 更新约束状态
            if (num1[chosen] < num2[i]) tight = false;

            // 记录选择
            res[i] = num1[chosen];
            used[chosen] = true;
        }

        // 构造最终结果
        int result = Integer.parseInt(new String(res));
        return result <= s2 ? result : -1;
    }

    public static int findMax(int[] arr, boolean[] use){
        int index = arr.length-1;
        for (int i = arr.length-1; i >= 0; i--) {
            if (use[i])
                break;
            index--;

        }
        return index;
    }
    public static int find(int[] arr, boolean[] use){
        int index = 0;
        for (int i = arr.length-1; i >=0 ; i--) {
            if (use[i]){
                index = i;
                break;
            }

        }
        return index;
    }

    public static int findSmaller(int[] arr1, int cur, boolean[] use){
        int index = 0;
        for (int j : arr1) {
            if (cur < j)
                break;
            index++;
        }
        for (int i = index; i >= 0; i--) {
            if (use[i])
                break;
            index--;
        }
        return index;
    }

    public static int index(int[] arr1, int cur){
        int index = 0;
        for (int i : arr1){
            if (i==cur)
                break;
            index++;
        }
        return index;
    }

    public static boolean ifIn(int[] arr1, int cur){
        for (int i : arr1)
            if (cur == i)
                return true;
        return false;
    }
}
