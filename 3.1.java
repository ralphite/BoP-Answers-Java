//bop 3.1

public class Main {
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "ACBD";
        System.out.println(rotateContains0(s1, s2));
        System.out.println(rotateContains1(s1, s2));
        System.out.println(rotateContains2(s1, s2));
        System.out.println(rotateContains3(s1, s2));
    }

    //naive
    public static boolean rotateContains0(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if ((s1.substring(i) + s1.substring(0, i)).contains(s2)) {
                return true;
            }
        }
        return false;
    }

    //simple code
    public static boolean rotateContains1(String s1, String s2) {
        return (s1 + s1).contains(s2);
    }

    //simple code performance improved
    public static boolean rotateContains2(String s1, String s2) {
        return (s1.substring(s1.length() - s2.length()) + s1.substring(0, s2.length())).contains(s2);
    }

    //best performance
    public static boolean rotateContains3(String s1, String s2) {
        for (int i = 0; i < s2.length(); i++) {
            if (s1.startsWith(s2.substring(i)) && s1.endsWith(s2.substring(0, i)))
                return true;
        }
        return false;
    }
}
