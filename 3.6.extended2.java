// bop 3.6.extended2

public class LinkedListUtils {
    public boolean checkIntersection(LinkedNode n1, LinkedNode n2) {
        if (n1==null || n2==null) return false;
        LinkedNode last1 = n1;
        LinkedNode last2 = n2;
        while (last1.next != null) last1 = last1.next;
        while (last2.next != null) last2 = last2.next;

        return last1 == last2;
    }

    public boolean checkIntersectionWithLoop(LinkedNode n1, LinkedNode n2) {
        if(!checkLoop(n1) && !checkLoop(n2))
            return checkIntersection(n1, n2);
        if(checkLoop(n1) && checkLoop(n2)) {
            LinkedNode first1 = getFirstNodeInLoop(n1);
            LinkedNode first2 = getFirstNodeInLoop(n2);
            LinkedNode cur = first2;
            if (cur == first1) return true;
            cur = cur.next;
            while(cur != first2) {
                if (cur == first1) return true;
                cur = cur.next;
            }
        }
        return false;
    }

    // tortoise hare method
    private boolean checkLoop(LinkedNode head) {
        if(head==null || head.next==null || head.next.next==null) return false;
        LinkedNode fast = head.next.next;
        LinkedNode slow = head.next;
        while(fast!=null && fast.next!=null) {
            if(fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    private LinkedNode getFirstNodeInLoop(LinkedNode head) {
        LinkedNode slow = head;
        LinkedNode fast = head.next;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedNode in = slow;
        slow = slow.next;
        int len = 1;
        while(slow != in) {
            slow = slow.next;
            len++;
        }
        slow = head;
        fast = head;
        for(int i = 0; i < len; i++) fast = fast.next;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public LinkedNode findFirstCommonNode(LinkedNode n1, LinkedNode n2) {
        assert !checkLoop(n1) && !checkLoop(n2);
        assert checkIntersection(n1, n2);

        LinkedNode cur1 = n1;
        while(cur1.next != null) cur1 = cur1.next;
        cur1.next = n2;

        return getFirstNodeInLoop(n1);
    }
}
