// bop 3.4

public class LinkedListUtils {
    public void checkIntersection(LinkedNode n1, LinkedNode n2) {
        if (n1==null || n2==null) return false;
        LinkedNode last1 = n1;
        LinkedNode last2 = n2;
        while (last1.next != null) last1 = last1.next;
        while (last2.next != null) last2 = last2.next;

        return last1 == last2;
    }
}
