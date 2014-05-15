//bop 2.1.2

public class BitwiseUtils {
    public static int diffCount(int a, int b) {
        return countOne(a ^ b);
    }

    public static int countOne(int n) {
        return countOne5(n);
    }

    //divide and conquer
     private static int countOne5(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555); //divide to 16 pairs. value of each pair is number of 1s in this pair
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333); //merge 2 pairs
        i = (i + (i >>> 4)) & 0x0f0f0f0f; //merge again
        i = i + (i >>> 8); // merge two bytes
        i = i + (i >>> 16); //merge two shorts
        return i & 0x3f; // only need last 6 bits since max is 32
    }
}
