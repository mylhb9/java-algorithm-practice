package test7;

import java.util.Scanner;

public class MergeSorting {
    int temp[] = new int[100005];
    public void merging(int[] arr, int s1, int e1, int s2, int e2) {
        int tempIdx = 0;
        int a = s1;
        int b = s2;

        while(a<=e1 && b<=e2) {
            if(arr[a] <= arr[b]) {
                temp[tempIdx] = arr[a];
                a++;
            } else {
                temp[tempIdx] = arr[b];
                b++;
            }
            tempIdx++;
        }

        while(a<=e1) {
            temp[tempIdx] = arr[a];
            a++;
            tempIdx++;
        }

        while(b<=e2) {
            temp[tempIdx] = arr[b];
            b++;
            tempIdx++;
        }

        for(int i=s1; i<=e2; i++) {
            arr[i] = temp[i-s1];
        }

    }
    public void mergeSort(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);

        merging(arr, start, mid, mid+1, end);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        MergeSorting m = new MergeSorting();
        m.mergeSort(arr, 0, n-1);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
