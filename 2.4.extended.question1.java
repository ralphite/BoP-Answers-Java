//bop 2.4.extended

public class BinUtils {
    
    //count number of 1s in n in binary format
    public static long bitCount(long n) {
        assert n > 0;
        return bitCount1(n);
    }

    //naive implmentation O(nlog(n))
    private static long bitCount1(long n) {
        long cnt = 0;
        for(int i = 1; i <= n; i++) {
            cnt += count(i);
        }
    }
    private static long count(long v) {
        if(v <= 0) return 0;
        long cnt = 0;
        while(v != 0) {
            v &= v - 1;
            cnt++;
        }
        return cnt;
    }

    //O(log(n))
    private static long bitCount2(long n) {
        // find the highest 1 bit O(log(log(n)))
        // say there are d digits after this 1 bit
        // flip the 1 bit and get n1
        // return n1+1 + bitCount2(n1) + 2^d*d/2
        // T(n)=O(log(log(n)))+T(n/2)+O(1)  
        // => time complexity is O(log(n))
        int d = findHighestOneBit(n) - 1;
        n &= ~(1 << d);

        return n+1 + bitCount2(n) + d*(1<<(d-1));
    }
    //return value is the 1 based index
    private static int findHighestOneBit(long n) {
        if(n < 0) return 32;
        int d = 0;
        if((n & 0xffffffff00000000L) > 0) {
            d += 32;
            n >>>= 32;
        }
        if((n & 0x00000000ffff0000L) > 0) {
            d += 16;
            d >>>= 16;
        }
        if((n & 0x000000000000ff00L) > 0) {
            d += 8;
            d >>>= 8;
        }
        if((n & 0x00000000000000f0L) > 0) {
            d += 4;
            d >>>= 4;
        }
        if(d >= 8) d += 4;
        else if(d >= 4) d += 3;
        else if(d >= 2) d += 2;
        else if(d >= 1) d += 1;
        return d;
    }
}
