package level15;

import java.util.Scanner;

public class ImplementMergeSort {
    int[] arr;
    int[] tempArr = new int[100001];
    public void merging(int start1, int end1, int start2, int end2) {

        int temp = 0;

        int p = start1;
        int q = start2;

        while(p <= end1 && q <= end2) {
            if(arr[p] <= arr[q]) {
                tempArr[temp++] = arr[p];
                p++;
            } else {
                tempArr[temp++] = arr[q];
                q++;
            }
        }

        while(p <= end1) {
            tempArr[temp++] = arr[p];
            p++;
        }

        while(q <= end2) {
            tempArr[temp++] = arr[q];
            q++;
        }

        for(int i=start1; i<=end2; i++) {
            arr[i] = tempArr[i-start1];
        }

    }

    public void mergeSort(int start, int end) {
        if(start >= end) {
            return;
        } else {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);

            merging(start, mid, mid+1, end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        ImplementMergeSort m = new ImplementMergeSort();
        m.arr = arr;
        m.mergeSort(0, n-1);
        for(int i=0; i<n; i++) {
            System.out.print(m.arr[i] + " ");
        }
    }
}
