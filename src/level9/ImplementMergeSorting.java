package level9;

import java.util.Scanner;

// 문제: n개의 정수가 주어질 떄, 이를 합병정렬을 이용하여 오름차순으로 정렬하는 프로그램을 작성
// 입력: 첫 번째 줄에 n이 주어진다. (1 <= n <= 100,000) 두번째 줄에 n개의 정수가 주어진다.
// 출력: 첫 번째 줄에 n개의 숫자를 합병정렬을 이용하여 오름차순으로 정렬한 결과를 출력
public class ImplementMergeSorting {
    Integer[] temp = new Integer[100001];

    public void merging(Integer[] arr, int start1, int end1, int start2, int end2) {
        int p, q;
        int tempIdx = 0;

        p = start1;
        q = start2;

        while(p <= end1 && q <= end2) {
            if(arr[p] > arr[q]) {
                temp[tempIdx] = arr[q];
                tempIdx++;
                q++;
            } else {
                temp[tempIdx] = arr[p];
                tempIdx++;
                p++;
            }
        }

        while(p <= end1) {
            temp[tempIdx] = arr[p];
            tempIdx++;
            p++;
        }

        while(q <= end2) {
            temp[tempIdx] = arr[q];
            tempIdx++;
            q++;
        }

        for(int i=start1; i<=end2; i++) {
            arr[i] = temp[i-start1];
        }

    }

    public void mergeSort(Integer[] arr, int start, int end) {
        if(start >= end) {
            return;
        } else {
            int mid = (start + end) / 2;

            mergeSort(arr, start , mid);
            mergeSort(arr, mid+1, end);

            merging(arr, start, mid, mid+1, end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= Integer.parseInt(sc.nextLine());

        String[] strArr = sc.nextLine().split(" ");
        Integer[] inputArr = new Integer[n];
        for(int i=0; i<n; i++) {
            inputArr[i] = Integer.parseInt(strArr[i]);
        }


        ImplementMergeSorting m = new ImplementMergeSorting();
        m.mergeSort(inputArr, 0, n-1);
        for(int i=0; i<n; i++) {
            System.out.print(inputArr[i] + " ");
        }
    }
}
