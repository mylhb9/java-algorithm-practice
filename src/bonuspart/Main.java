package bonuspart;

import java.util.Scanner;

public class Main {
    int[] temp = new int[100001];
    public void merge(int[] arr, int s1, int e1, int s2, int e2) {
        int p = s1;
        int q = s2;


        int idx = 0;
        while(p <= e1 && q <=e2) {
            if(arr[p] <arr[q]) {
                temp[idx++] = arr[p];
                p++;
            } else {
                temp[idx++] = arr[q];
                q++;
            }
        }

        while(p <= e1) {
            temp[idx++] = arr[p];
            p++;
        }

        while(q <= e2) {
            temp[idx++] = arr[q];
            q++;
        }
        for(int i=s1; i<=e2; i++) {
            arr[i] = temp[i-s1];
        }
    }


    public void mergeSort(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        } else {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, mid+1, end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Main m = new Main();
        m.mergeSort(arr, 0, n-1);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
