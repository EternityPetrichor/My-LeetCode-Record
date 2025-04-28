package Hot100.linkedlist;

public class T141 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        ListNode head = T206.creatLinkedList(nums);

    }

    /*O（1）空间复杂度解法，快慢指针*/
    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null)
            return false;
        ListNode fast = head, slow = head;

        do{
            if (fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            } else return false;
        } while (fast != slow);

        return true;
    }


    /*暴力解法*/
    /*public boolean hasCycle(ListNode head) {
        ListNode current = head;
        Set<ListNode> set = new HashSet<>();
        while (current != null){
            if (set.contains(current))
                return true;
            set.add(current);
            current = current.next;
        }

        return false;
    }*/
}
