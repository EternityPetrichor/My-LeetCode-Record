package Hot100.linkedlist;

public class T24 {
    public static void main(String[] args) {
        ListNode head = T206.creatLinkedList(new int[]{1, 2, 3, 4});
        head = swapPairs1(head);
        T206.printLinkedList(head);
    }

    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head.next;
        head.next = swapPairs1(p.next);
        p.next = head;
        return p;
    }


    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        ListNode p = head;
        ListNode pre = null;

        while (p != null && p.next != null){
            head = p;
            p = head.next.next;
            if (pre != null){
                pre.next = head.next;
            }
            pre = head;
            head.next.next = head;
            head.next = p;

        }
        return newHead;
    }
}
