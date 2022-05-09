package level16;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[100001];
        Arrays.fill(dp, 123456);
        for(int i=1; i*i<=N; i++) {
            dp[i*i] = 1;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i-j*j] + 1, dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}

// 1 1 / 1개
// 2 1+1 / 2개
// 3 1+1+1 / 3개
// 4 4 / 1개
// 5 4+1 / 2개
