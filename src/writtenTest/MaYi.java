package writtenTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaYi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] value = new int[n];
        for(int i = 0;i<n;i++){
            value[i] = in.nextInt();
        }
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        Set<Integer> set = new HashSet<>();
        int score = 0;

        if(ifContsins(chars, set)){
            for(int v : value){
                score += v;
            }
        } else{
             for(int i=0;i<chars.length;i++){
                 if(set.contains(i)){
                     score+=Math.max(value[i],value[i+1]);
                     score+=Math.max(value[i+1],value[i+2]);
                     i+=3;
                 }else{
                     score+=value[i];
                 }
             }
        }

        System.out.print(score);

    }

    public static boolean ifContsins(char[] chars, Set<Integer> set){
        for(int i = 0;i<chars.length-2;i++){
            if(chars[i]=='1'&&chars[i+1]=='1'&&chars[i+2]=='0'){
                set.add(i);
                i+=3;
            }
        }

        return set.isEmpty();
    }
}
