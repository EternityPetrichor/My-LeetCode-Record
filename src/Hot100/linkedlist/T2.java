package Hot100.linkedlist;

public class T2 {
    public static void main(String[] args) {
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 0;
        ListNode head = new ListNode(), p = head;
        int number1, number2;
        while (l1 != null || l2 != null){
            if (l1 == null)
                number1 = 0;
            else {
                number1 = l1.val;
                l1 = l1.next;
            }
            if (l2 == null)
                number2 = 0;
            else {
                number2 = l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode();
            int count = i==0?number1+number2:number1+number2+i;
            node.val = count % 10;
            i = count / 10;
            p.next = node;
            p = p.next;


        }
        if (i!=0){
            p.next = new ListNode(i);
        }
        return head.next;
    }
}
