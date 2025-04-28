package Hot100.linkedlist;

public class T234 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        ListNode head = T206.creatLinkedList(nums);
        if (head != null) {
            System.out.println(isPalindrome(head));
        }
    }

    /*用 O(n) 时间复杂度和 O(1) 空间复杂度解决*/
    /*思路就是先用快慢指针，将链表均分两半，后一半使用反转链表，这样就能对其使用常规的判断回文的方法，最后记得要恢复后一半的链表*/
    public static boolean isPalindrome(ListNode head){
        if (head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null){
            fast = fast.next;
            if (fast.next != null){
                fast = fast.next;

            }
            slow = slow.next;
        }
        T206.reverseList(slow);
        ListNode left = head;
        ListNode right = fast;
        /*System.out.println("截一半翻转：");
        T206.printLinkedList(fast);*/
        while (left != right && right!= null){
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        T206.reverseList(fast);
        /*System.out.println("恢复：");
        T206.printLinkedList(head);*/
        return true;
    }




    /*空间复杂度O（n）就是用数组或者栈之类的存入链表的节点值，然后用双指针去判断是不是回文*/
    /*public static boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null){
            list.add(current.val);
            current = current.next;
        }
        Integer[] array = list.toArray(new Integer[0]);
        int left = 0, right = array.length-1;
        while (left<right){
            if (!Objects.equals(array[left], array[right]))
                return false;
            left++;
            right--;
        }
        return true;
    }*/
}
