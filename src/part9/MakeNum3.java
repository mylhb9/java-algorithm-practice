package part9;

import java.util.Scanner;

public class MakeNum3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] dp = new Integer[100001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=1; i<N-2; i++) {
            dp[i+3] = (dp[i+2] + dp[i+1] + dp[i]) % 1000007;
        }
        System.out.println(dp[N]);
    }
}
// 1      / 1
// 1+1  2 / 2
// 1+1+1  2+1  1+2  3  / 4
// 1+1+1+1 2+1+1  1+2+1  3+1  1+1+2  2+2  1+3  / 7
// 7 + 4 + 2 / 13