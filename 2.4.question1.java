//bop 2.4.question1

package com.ralphwen;

public class Main {

    // O(log(n))
    // easier to understand with recursion
    public static long countOne(long n) {
        if(n <= 0) return 0;
        if(n < 10) return 1;
        long d = n;
        int c = 0;
        int p = 1;
        while (d/10 > 0) {
            d /= 10;
            c++;
            p *= 10;
        }
        // d is the first digit now
        // c is number of digits after d
        // p is smallest number with same length as n
        long r = n - d * p;
        long rc = countOne(r);
        if(d == 1) {
            return rc + r + 1 + p*c/10;
        }
        return rc + p*c/10*d + p;
    }

    // O(nlog(n))
    public static long countOne2(long n) {
        int c = 0;
        for(int i = 1; i <= n; i++) {
            c += cnt(i);
        }
        return c;
    }
    private static long cnt(long n) {
        assert n > 0;
        int c = 0;
        while(n!=0) {
            c += n % 10 == 1 ? 1 : 0;
            n /= 10;
        }
        return c;
    }

    public static void main(final String... args) {
        long[] t = new long[]{-1L, -10000L, 0L, 1L, 2L, 8L, 10L, 16L, 23L, 78L,
                100L, 143L, 11113L, 4124556L, 107832489123L};
        for(long tt : t) {
            System.out.println(tt + " : " + countOne(tt) + ", "
                    + countOne2(tt) + ","
                    + (countOne(tt) == countOne2(tt)));
        }
    }
}
