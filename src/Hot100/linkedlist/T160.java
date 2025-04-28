package Hot100.linkedlist;


import java.util.HashSet;
import java.util.Set;

public class T160 {
    public static void main(String[] args) {

    }

    /*统一深度,按尾端对齐*/
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode n1 = headA;
        ListNode n2 = headB;
        int l1 = 1, l2 =1;
        while (n1.next != null){
            l1++;
            n1 = n1.next;
        }

        while (n2.next != null){
            l2++;
            n2 = n2.next;
        }

        n1 = headA;
        n2 = headB;
        if (l1 > l2){
            int diff=l1-l2;
            while (diff>0){
                n1 = n1.next;
                diff--;
            }
        } else{
            int diff = l2-l1;
            while (diff>0){
                n2 = n2.next;
                diff--;
            }
        }
        while (n1!=null){
            if (n1 == n2)
                return n1;
            else{
                n1=n1.next;
                n2=n2.next;
            }

        }

        return null;
    }

    /*双指针，本质上等同于上面的统一深度*/
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if (headA == null || headB == null)
            return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p2 != p1){
            if (p2 == null){
                p2 = headA;
                continue;
            }

            if (p1 == null){
                p1 = headB;
                continue;
            }

            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }

    /*哈希集合*/
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        Set<ListNode> set = new HashSet<>();
        ListNode n1 = headA;

        while (n1 != null){
            set.add(n1);
            n1 = n1.next;
        }
        n1 = headB;
        while (n1 != null){
            if (set.contains(n1))
                return n1;
            n1 = n1.next;
        }

        return null;
    }
}
