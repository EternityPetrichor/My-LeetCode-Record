package Hot100.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class T142 {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast == null || fast.next == null)
            return null;
        ListNode newNode = head;
        while (newNode != slow){
            newNode = newNode.next;
            slow = slow.next;
        }
        return newNode;
    }

    public static ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null)
            return null;
        Set<ListNode> set = new HashSet<>();
        set.add(head);
        ListNode node = head.next;
        while (!set.contains(node)){
            if (node==null)
                return null;
            set.add(node);
            node = node.next;
        }

        return node;
    }

}
