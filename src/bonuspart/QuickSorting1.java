package bonuspart;

// 문제: N개의 자연수가 주어질 때, 퀵정렬을 이용하여 이를 정렬하는 프로그램을 작성

// 입력: 첫 번째 줄에 N이 주어짐
// 두 번째 줄에 N개의 자연수가 주어짐

// 출력: 퀵정렬을 이용하여 숫자를 오름차순으로 정렬한 결과를 출력한다.

import java.util.Scanner;

public class QuickSorting1 {
    int[] left = new int[100001];
    int[] right = new int[100001];
    public int makeLeft(int[] arr, int start, int end, int pivot, int[] left) {
        int idx = 0;
        for(int i=start; i<=end; i++) {
            if(arr[i] <= pivot) {
                left[idx++] = arr[i];
            }
        }
        return idx;
    }

    public int makeRight(int[] arr, int start, int end, int pivot, int[] right) {
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

            int leftNum = makeLeft(arr, start+1, end, pivot, left);
            int rightNum = makeRight(arr, start+1, end, pivot, right);

            for(int i=start; i< start+leftNum; i++) {
                arr[i] = left[i-start];
            }
            arr[start+leftNum] = pivot;
            for(int i = start+leftNum+1; i<=end; i++) {
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
        QuickSorting1 m = new QuickSorting1();

        m.quickSort(arr, 0, N-1);

        for(int i=0; i<N; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
