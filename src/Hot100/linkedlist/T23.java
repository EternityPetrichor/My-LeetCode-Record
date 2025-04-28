package Hot100.linkedlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T23 {
    public static void main(String[] args) {
        System.out.println("合并k个升序链表");
        mergeKLists1(new ListNode[]{});
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists)
            if (node!=null){
                queue.add(node);
            }

        while (!queue.isEmpty()){
            p.next = queue.poll();
            p = p.next;
            if (p.next!=null)
                queue.add(p.next);
        }
        return dummy.next;
    }

    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists)
            if (node!=null){
                queue.add(node);
            }
        ListNode p;
        ListNode dummy = new ListNode(0);
        p = dummy;
        while (!queue.isEmpty()){
            p.next = queue.poll();
            p = p.next;
            if (p.next!=null)
                queue.add(p.next);
        }
        return dummy.next;
    }
}
