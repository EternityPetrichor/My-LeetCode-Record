package writtenTest;

import java.util.*;

public class yuLiangSheng {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars)
            map.put(c, map.getOrDefault(c, 0)+1);
        if (ifChongPai(str, n, map)){
            System.out.println("yes");
            while (!ifBiaoZhun(chars)){
                chongPai(chars, map);
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (char c : chars)
                stringBuffer.append(c);
            System.out.println(stringBuffer);
        } else {
            System.out.println("no");
        }
    }

    public static boolean ifChongPai(String str, int n, Map<Character, Integer> map){
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue()>n/2)
                return false;
        }
        return true;
    }

    public static boolean ifBiaoZhun(char[] chars){
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i+1])
                return false;
        }
        return true;
    }

    public static void chongPai(char[] chars, Map<Character, Integer> map){
        char[] newChar = new char[chars.length];
        Random random = new Random();
        Character[] array = map.keySet().toArray(new Character[0]);
        for (char c : newChar){
            c = getRandom(array, random, map);
            map.put(c, map.get(c)-1);
        }
        chars = newChar;
    }

    public static char getRandom(Character[] characters, Random random, Map<Character, Integer> map){
        int i = random.nextInt(characters.length);
        while (true){
            if (map.get(characters[i])!=0)
                break;
            else i = random.nextInt(characters.length);
        }
        return characters[i];

    }

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        String fatherNodeStr = in.nextLine();
        int[] fatherNode = new int[num];
        fatherNode[0] = 0;
        String[] split = fatherNodeStr.split(" ");
        for (int i = 0; i < split.length; i++) {
            fatherNode[i+1] = Integer.parseInt(split[i]);
        }
        char[] colorChar = in.nextLine().toCharArray();
        int q = in.nextInt();
        while ( q > 0){
            int question = in.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(question);
            int result = calcRed(queue, fatherNode, colorChar);
            System.out.println(result);
            q--;
        }

    }

    public static int calcRed(Queue<Integer> queue, int[] fatherNode, char[] colorChar){
        int count = 0;
        while (!queue.isEmpty()){
            int cur = queue.poll()-1;
            if (colorChar[cur] == 'R'){
                count++;
            }
            searchForTarget(queue, cur+1, fatherNode);
        }
        return count;
    }

    public static void searchForTarget(Queue<Integer> queue, int question, int[] fatherNode){
        for (int i = 0; i < fatherNode.length; i++) {
            if (question == fatherNode[i])
                queue.offer(i+1);
        }
    }*/




    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String s = in.next();
        char[] chars = s.toCharArray();
        char[] gbr = new char[]{'G', 'B', 'R'};
        int count = 0;
        char pre, next;
        for (int i = 1; i < length-1; i++) {
            pre = chars[i-1];
            next = chars[i+1];
            if (pre == chars[i] && pre == next){
                chars[i] = change(gbr, chars[i]);
                count++;
            }
            if (pre == chars[i] || next == chars[i]){
                chars[i] = change1(gbr, pre, next);
                count++;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : chars)
            stringBuffer.append(c);
        if (count > length/2)
            System.out.println(stringBuffer);
        else System.out.println(stringBuffer);
    }

    public static char change(char[] gbr, char cur){
        char result = gbr[0];
        for(char c : gbr){
            if (cur != c){
                result = c;
                break;
            }
        }
        return result;
    }

    public static char change1(char[] gbr, char pre, char next){
        char result = gbr[0];
        for(char c : gbr){
            if (pre != c && next != c){
                result = c;
                break;
            }
        }
        return result;
    }*/
}
