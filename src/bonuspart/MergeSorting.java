package bonuspart;

import java.util.Scanner;

public class MergeSorting {
    Integer[] tempArr = new Integer[100001];
    public void merging(Integer[] arr, int start1, int end1, int start2, int end2) {
        int p, q;


        p = start1;
        q = start2;

        int temp = 0;

        while(p <= end1 && q <= end2) {
            if(arr[p] > arr[q]) {
                tempArr[temp] = arr[q];
                temp++;
                q++;
            } else {
                tempArr[temp] = arr[p];
                temp++;
                p++;
            }
        }

        while(p <= end1) {
            tempArr[temp] = arr[p];
            temp++;
            p++;
        }

        while(q <= end2) {
            tempArr[temp] = arr[q];
            temp++;
            q++;
        }

        for(int i=start1; i<=end2; i++) {
            arr[i] = tempArr[i-start1];
        }
    }

    public void mergeSorting(Integer[] arr, int start, int end) {
        if(start >= end) {
            return;
        } else {
            int mid = (start + end) / 2;

            mergeSorting(arr, start, mid);
            mergeSorting(arr, mid+1, end);

            merging(arr, start, mid, mid+1, end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Integer[] inputArr = new Integer[n];
        for(int i=0; i<n; i++) {
            inputArr[i] = sc.nextInt();
        }

        MergeSorting m = new MergeSorting();
        m.mergeSorting(inputArr, 0, n-1);
        for(int i=0; i<n; i++) {
            System.out.print(inputArr[i] + " ");
        }
        sc.close();
    }
}
