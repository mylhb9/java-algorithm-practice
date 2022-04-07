package part9;

import java.util.*;

public class SumOfSquares2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Integer[] table = new Integer[N+1];
        Arrays.fill(table, 100001);
        for(int i=1; i*i<=N; i++) {
            table[i*i] = 1;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j*j<=i; j++) {
                table[i] = Math.min(table[i], table[i-j*j]+1);
            }
        }
        System.out.println(table[N]);
    }
}
