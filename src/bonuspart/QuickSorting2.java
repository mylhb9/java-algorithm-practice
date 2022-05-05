package bonuspart;

import java.util.Scanner;

public class QuickSorting2 {
    int[] left = new int[100001];
    int[] right = new int[100001];

    public int makeLeft(int[] arr, int start, int end, int pivot) {
        int idx = 0;
        for(int i=start; i<=end; i++) {
            if(arr[i] <= pivot) {
                left[idx++] = arr[i];
            }
        }
        return idx;
    }
    public int makeRight(int[] arr, int start, int end, int pivot) {
        int idx = 0;
        for(int i=start; i<=end; i++) {
            if(arr[i] > pivot) {
                right[idx++] = arr[i];
            }
        }
        return idx;
    }
    public void quickSort(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        } else {
            int pivot = arr[start];

            int leftNum = makeLeft(arr, start+1, end, pivot);
            int rightNum = makeRight(arr, start+1, end, pivot);

            for(int i=start; i<start+leftNum; i++) {
                arr[i] = left[i-start];
            }
            arr[start+leftNum] = pivot;
            for(int i=start+leftNum+1; i<=end; i++) {
                arr[i] = right[i-start-leftNum-1];
            }

            quickSort(arr, start, start+leftNum-1);
            quickSort(arr, start+leftNum+1, end);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        QuickSorting2 m = new QuickSorting2();
        m.quickSort(arr, 0, N-1);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
