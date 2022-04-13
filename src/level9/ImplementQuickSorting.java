package level9;

import java.util.Scanner;

// 문제: N개의 자연수가 주어질 때, 퀵정렬을 이용하여 이를 정렬하는 프로그램을 작성
// 입력: 첫 번째 줄에 N (1 <= N <= 100,000) 가 주어지고, 두 번째 줄에 N개의 자연수가 주어진다.
// 출력: 퀵정렬을 이용하여 숫자를 오름차순으로 정렬한 결과를 출력
public class ImplementQuickSorting {
    int n;
    public int leftJudge(int pivot, Integer[] arr, Integer[] result, int start, int end) {
        int idx = 0;
        for(int i=start; i<=end; i++) {
            if(arr[i] <= pivot) {
                result[idx] = arr[i];
                idx++;
            }
        }
        return idx;
    }

    public int rightJudge(int pivot, Integer[] arr, Integer[] result, int start, int end) {
        int idx = 0;
        for(int i=start; i<=end; i++) {
            if(arr[i] > pivot) {
                result[idx] = arr[i];
                idx++;
            }
        }
        return idx;
    }

    public void quickSort(Integer[] arr, int start, int end) {
        if(start >= end) {
            return;
        } else {
            int pivot = arr[start];
            Integer[] leftResult = new Integer[n+1];
            int leftLength = leftJudge(pivot, arr, leftResult,start+1, end);
            Integer[] rightResult = new Integer[n+1];
            int rightLength = rightJudge(pivot, arr, rightResult,start+1, end);

            for(int i=start; i<start+leftLength; i++) {
                arr[i] = leftResult[i-start];
            }
            arr[start+leftLength] = pivot;
            for(int i=start+leftLength+1; i<start+leftLength+1+rightLength; i++) {
                arr[i] = rightResult[i-start-leftLength-1];
            }
            quickSort(arr, start, start+leftLength-1);
            quickSort(arr, start+leftLength+1, end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] strArr = sc.nextLine().split(" ");
        Integer[] inputArr = new Integer[N];
        for(int i=0; i<N; i++) {
            inputArr[i] = Integer.parseInt(strArr[i]);
        }

        ImplementQuickSorting m = new ImplementQuickSorting();
        m.n = N;
        m.quickSort(inputArr, 0, N-1);

        for(int i=0; i<N; i++) {
            System.out.print(inputArr[i] + " ");
        }
    }
}