package level15;

import java.util.Scanner;

public class ConsecutiveSubMaximum {
    int[] arr;
    public int getSum(int start, int end) {
        if(start >= end) {
            return arr[start];
        } else {
            int mid = (start + end) / 2;

            int left = getSum(start, mid);
            int right = getSum(mid+1, end);

            int sum1 = 0;
            int leftValue = Integer.MIN_VALUE;
            for(int i=mid; i>=start; i--) {
                sum1+=arr[i];
                if(leftValue < sum1) {
                    leftValue = sum1;
                }
            }

            int sum2 = 0;
            int rightValue = Integer.MIN_VALUE;
            for(int i=mid+1; i<=end; i++) {
                sum2+=arr[i];
                if(rightValue < sum2) {
                    rightValue = sum2;
                }
            }
            return Math.max(Math.max(left, right), rightValue+leftValue);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        ConsecutiveSubMaximum m = new ConsecutiveSubMaximum();
        m.arr = arr;
        System.out.println(m.getSum(0, n-1));

    }
}
