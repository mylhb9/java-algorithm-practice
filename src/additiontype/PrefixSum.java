package additiontype;

import java.util.Scanner;

public class PrefixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            int a = sc.nextInt();
            arr[i] = a + arr[i-1];
        }

        for(int i=0; i<M; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(arr[r]-arr[l-1]);
        }
        sc.close();
    }
}
