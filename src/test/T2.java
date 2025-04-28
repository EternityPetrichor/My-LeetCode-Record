package test;

import java.util.Arrays;

public class T2 {
    public String test(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='a'||chars[i]=='e'||chars[i]=='i'||chars[i]=='o'||chars[i]=='u'){
                String temp = String.valueOf(chars[i]);
                String s = temp.toUpperCase();
                chars[i] = s.charAt(0);
            } else if (chars[i] == ' ') {
            }
            else {
                String temp = String.valueOf(chars[i]);
                String s = temp.toLowerCase();
                chars[i] = s.charAt(0);
            }
        }
        return Arrays.toString(chars);
    }
}
