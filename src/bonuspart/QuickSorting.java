package bonuspart;

import java.util.Scanner;

public class QuickSorting {
    int[] leftArr = new int[100001];
    int[] rightArr = new int[100001];
    public void quickSorting(Integer[] arr, int start, int end) {
        if (start >= end) {
            return;
        } else {
            int pivot = arr[start];

            int leftIdx = 0;
            int rightIdx = 0;
            for (int i = start + 1; i <= end; i++) {
                if (arr[i] < pivot) {
                    leftArr[leftIdx++] = arr[i];
                } else {
                    rightArr[rightIdx++] = arr[i];
                }
            }

            for (int i = start; i < start + leftIdx; i++) {
                arr[i] = leftArr[i - start];
            }
            arr[start + leftIdx] = pivot;
            for (int i = start + leftIdx + 1; i <= end; i++) {
                arr[i] = rightArr[i - start - leftIdx - 1];
            }

            quickSorting(arr, start, start + leftIdx - 1);
            quickSorting(arr, start + leftIdx+1, end);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] inputArr = new Integer[N];
        for(int i=0; i<N; i++) {
            inputArr[i] = sc.nextInt();
        }
        QuickSorting m = new QuickSorting();
        m.quickSorting(inputArr, 0, N-1);
        for(int i=0; i<N; i++) {
            System.out.print(inputArr[i] + " ");
        }
    }
}
