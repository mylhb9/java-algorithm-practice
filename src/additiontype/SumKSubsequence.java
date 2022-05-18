package additiontype;

import java.util.Scanner;

public class SumKSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int count = 0;
        int[] A = new int[N];
        A[0] = sc.nextInt();
        for(int i=1; i<N; i++) {
            int a = sc.nextInt();
            A[i] = a;
            int sum = 0;
            for(int j=i; j>=0; j--) {
                sum += A[j];
                if(sum == K) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
