package Hot100.linkedlist;

public class T86 {
    public static void main(String[] args) {
        System.out.println("分离链表");
    }

    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode pHead1 = new ListNode(-1);
        ListNode pHead2 = new ListNode(-1);
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p != null){
            if (p.val < x){
                p1.next = p;
                p1 = p1.next;
            }
            else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode temp = p;
            p = p.next;
            temp.next = null;
        }
        p1.next = pHead2.next;
        return pHead1.next;
    }
}
