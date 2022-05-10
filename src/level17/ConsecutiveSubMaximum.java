package level17;

import java.util.Scanner;

public class ConsecutiveSubMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        arr[0] = sc.nextInt();
        for(int i=1; i<n; i++) {
            int pivot = sc.nextInt();
            arr[i] = Math.max(arr[i-1] + pivot, pivot);
        }

        int max = -987987987;
        for(int i=0; i<n; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
    }
}
