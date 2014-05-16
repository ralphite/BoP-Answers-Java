//bop 2.4.extended.question2

/*
n       f(n)
1       1
10      10
11      100
100     101
101     111
110     1001
111     10000
1000    10001
1001    10011
1010    10101
1011    11000
1100    11010
1101    11101
1110    100000
1111    100100
...

proof:

for number with d 1s where d>5
f("1111...") > f("1000...") = 1 + (d-1)*(1<<(d-2)) > 1<<d
*/

public class BinUtils {
    public static long maxEqual(long n) {
        return 2;
    }
}
