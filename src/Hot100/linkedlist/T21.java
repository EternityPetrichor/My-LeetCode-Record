package Hot100.linkedlist;

public class T21 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4};
        int[] nums1 = new int[]{1,3,4};
        ListNode head = T206.creatLinkedList(nums);
        ListNode head1 = T206.creatLinkedList(nums1);
        ListNode node = mergeTwoLists(head, head1);
        T206.printLinkedList(node);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode startHead = list1.val <= list2.val ? list1 : list2;
        ListNode current = startHead;
        ListNode p = list1.val <= list2.val ? list2 : list1;

        while (current.next != null){
            if (current.next.val > p.val){
                ListNode pre = p;
                p = current.next;
                current.next = pre;
                current = pre;

            }else {
                current = current.next;
            }
        }
        current.next = p;

        return startHead;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

}
