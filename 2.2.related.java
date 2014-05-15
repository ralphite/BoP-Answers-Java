//bop 2.2.related

public class IntUtils {
    public static boolean powerOf2(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
