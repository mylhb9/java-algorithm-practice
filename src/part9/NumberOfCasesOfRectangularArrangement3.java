package part9;

import java.util.Scanner;

public class NumberOfCasesOfRectangularArrangement3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] dp = new Integer[101];
        dp[1] = 1;
        dp[2] = dp[1] + 1;
        for(int i=1; i<N-1; i++) {
            dp[i+2] = (dp[i+1] + dp[i]) % 1000007;
        }
        System.out.println(dp[N]);
    }
}
