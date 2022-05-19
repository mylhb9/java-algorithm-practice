package part1;

import java.util.Scanner;

public class JudgeDecimal2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        boolean[] check = new boolean[20005];
        check[1] = true;
        for(int i=2; i<=n; i++) {
            if(Math.sqrt(Integer.MAX_VALUE) <= i) {
                break;
            }
            for(int j=i*i; j<=n; j+=i) {
                check[j] = true;
            }
        }

        if(check[n]) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
        sc.close();
    }
}
