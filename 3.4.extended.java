// bop 3.4.extended

public class LinkedListUtils {
    public LinkedNode reverse(LinkedNode head) {
        LinkedNode dmy = new LinkedNode();
        LinkedNode cur = head;
        while(cur != null) {
            LinkedNode oldFirst = dmy.next;
            dmy.next = cur;
            LinkedNode oldNext = cur.next;
            cur.next = oldFirst;
            cur = oldNext;
        }
        return dmy.next;
    }
}
