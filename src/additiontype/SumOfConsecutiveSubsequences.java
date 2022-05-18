package additiontype;

import java.util.Scanner;

public class SumOfConsecutiveSubsequences {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();


        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
        }


        int[] sumArr = new int[100005];
        int max = -987987987;
        for(int i=1; i<=N-(K-1); i++) {

            for(int j=0; j<K; j++) {
                sumArr[i] += arr[i+j];
            }
            if(max < sumArr[i]) {
                max = sumArr[i];
            }
        }


        System.out.println(max);
        sc.close();
    }
}
