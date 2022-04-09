package part9;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfSquares3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] dp = new Integer[100001];
        Arrays.fill(dp, 1000000);
        for(int i=1; i*i<=N; i++)  {
            dp[i*i] = 1;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
// 1: 1
// 2: 2
// 3: 3
// 4: 1
// 5: 2
// 6: 3
// 7: 4
// 8: 2