package Hot100.linkedlist;

public class T206 {
    /*static {
        System.out.println("Static block in T206 executed");
    }*/
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        ListNode head = creatLinkedList(nums);
        head = reverseList(head);
        printLinkedList(head);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = null;
        ListNode current = head;
        while (current != null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static ListNode creatLinkedList(int[] nums){
        if (nums.length == 0)
            return null;
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }

        return head;
    }

    public static void printLinkedList(ListNode head){
        ListNode current = head;
        while (current != null){
            if (current.next == null)
                System.out.print(current.val);
            else System.out.print(current.val + "->");
            current = current.next;
        }
    }
}
