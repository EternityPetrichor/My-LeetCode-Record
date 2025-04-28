package writtenTest;

import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int x){
        val = x;
    }
}

public class Shopee {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(t1(str));
    }

    public static int t1(String str){
        if (str.length() < 2)
            return str.length();
        Map<Character, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;
        char[] chars = str.toCharArray();
        int left = 0, right = 1;
        while (right < str.length()){
            if (map.containsKey(chars[right]))
                left = Math.max(left, map.get(chars[right])+1);
            map.put(chars[right],right);
            result = Math.max(result, right-left);
            right++;
        }
        return result;
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ListNode l1 = new ListNode();
        ListNode h = l1;
        ListNode l2 = new ListNode();
        String[] split = s.split("L2");
        String s1 = split[0].substring(split[0].indexOf("[") + 1, split[0].indexOf("]"));
        String s2 = split[1].substring(split[1].indexOf("[") + 1, split[1].indexOf("]"));
        String[] split1 = s1.split(",");
        String[] split2 = s2.split(",");
        for (String sub : split1){
            h.next  = new ListNode(Integer.parseInt(sub));
            h = h.next;
        }
        h = l2;
        for (String sub : split2){
            h.next  = new ListNode(Integer.parseInt(sub));
            h = h.next;
        }
        ListNode head = t2(l1.next, l2.next);
        System.out.print("[");
        while (head.next!=null){
            System.out.print(head.val);
            System.out.print(",");
            head = head.next;
        }
        System.out.print(head.val);
        System.out.print("]");
    }

    public static ListNode t2(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1!=null && l2!=null){
            if (l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1!= null)
            current.next = l1;
        else if (l2 != null) {
            current.next = l2;
        }
        return head.next;
    }

    /*public static List<Integer> t2(List<Integer> list1, List<Integer> list2){
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (left<list1.size() && right<list2.size()){
            if (list1.get(left)<list2.get(right)){
                result.add(list1.get(left));
                left++;
            }
            else {
                result.add(list2.get(right));
                right++;
            }
        }
        while (right<list2.size()){
            result.add(list2.get(right));
            right++;
        }
        while (left<list1.size()){
            result.add(list1.get(left));
            left++;
        }
        return result;
    }*/

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] split = string.split(",");
        String s = split[0].substring(split[0].indexOf("\"")+1, split[0].lastIndexOf("\""));
        int k = Integer.parseInt(split[1].substring(split[1].lastIndexOf(" ")+1));
        Set<Character> yuanyin = new HashSet<>();
        yuanyin.add('a');
        yuanyin.add('e');
        yuanyin.add('i');
        yuanyin.add('o');
        yuanyin.add('u');
        System.out.println(t3(yuanyin, s, k));
    }

    public static int t3(Set<Character> yuanyin, String s, int k){
        int count = 0;
        int left = 0;
        int right = 0;
        while (right - left +1 == k && right<s.length()){
            if (yuanyin.contains(s.charAt(right)))
                count++;
            right++;
        }
        while (right < s.length()-1){
            if (!yuanyin.contains(s.charAt(left))&&yuanyin.contains(s.charAt(right+1)))
                count = Math.max(count, count+1);
            else if (yuanyin.contains(s.charAt(left)) && !yuanyin.contains(s.charAt(right + 1))) {
                count = Math.max(count, count-1);
            }
            left++;
            right++;
        }

        return count;
    }*/

}
