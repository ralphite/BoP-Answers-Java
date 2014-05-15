//bop 2.1.1

public class BitwiseUtils {
    public static int countOne(int n) {
        return countOne1(n);
    }

    //naive
    private static int countOne1(int n) {
        if(n < 0) {
            return 32 - countOne1(~n);
        }
        int cnt = 0;
        while(n > 0) {
            if(n % 2 != 0) {
                cnt++;
            }
            n /= 2;
        }
        return cnt;
    }

    //optimize % and / with bit shifting
    private static int countOne2(int n) {
        int cnt = 0;
        while(n != 0) {
            cnt += n & 1;
            n >>>= 1;
        }
        return cnt;
    }

    //avoid bit shifting
    private static int countOne3(int n) {
        int cnt = 0;
        while(n != 0) {
            n &= n - 1;
            cnt++;
        }
        return cnt;
    }

    //table query. space time tradeoff. 
    private static final int[] table = new int[] {0, 1, 1, 2, 1, 5, 5, 3, 1, ....};
    private static int countOne4(int n) {
        int n1 = n & 0x000000ff;
        int n2 = (n & 0x0000ff00) >>> 8;
        int n3 = (n & 0x00ff0000) >>> 16;
        int n4 = (n & 0xff000000) >>> 24;
        
        return table[n1] + table[n2] + table[n3] + table[n4];
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
