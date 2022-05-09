package level14;

import java.math.BigInteger;
import java.util.Scanner;

public class FindAPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        BigInteger m = sc.nextBigInteger();
        m = m.remainder(BigInteger.valueOf(10006));

        int[] results = new int[10008];
        int result = 1;
        results[0] = 0;
        for(int i=0; i<10006; i++) {
            result *= n;
            if(result >= 10007) {
                result %= 10007;
            }
            results[i+1] = result;
        }

        System.out.println(results[m.intValue()]);

    }
}
// 7
// n m    results
// 3 1 3    3     1
// 3 2 9    2     2
// 3 3 27   6     3
// 3 4 81   4     4
// 3 5 243  5     5
// 3 6 729  1     6
// 3 7 2187 3     1