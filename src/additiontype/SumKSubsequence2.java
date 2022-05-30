package additiontype;

import java.util.Scanner;

public class SumKSubsequence2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }



        int sum = 0;
        int end = 0;
        int count = 0;

        for(int i=0; i<N; i++) {
            while(sum < K && end <N) {
                sum += arr[end];
                end++;
            }
            if(sum == K) {
                count++;
            }
            sum-=arr[i];
        }

        System.out.println(count);


        sc.close();
    }
}
