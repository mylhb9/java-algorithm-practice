package level16;

import java.util.Arrays;
import java.util.Scanner;

public class MarblePlay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[1000001];
        Arrays.fill(dp, 1);
        for(int i=0; i<=n; i++) {
            if(i%4==0) {
                dp[i] = 0;
            }
        }
        if(dp[n] == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
