package bonuspart;

// 문제: n개의 정수가 주어질 때, 이를 합병정렬을 이용하여 오름차순으로 정렬하는 프로그램을 작성

// 입력: 첫 번째 줄에 n이 주어진다 (1<= n <= 100,000)
// 두번째 줄에 n개의 정수가 주어진다.

import java.util.Scanner;

// 출력: 첫 번째 줄에 n개의 숫자를 합병정렬을 이용하여 오름차순으로 정렬한 결과를 출력
public class MergeSorting1 {
    int[] temp = new int[100001];
    public void merging(int[] arr, int s1, int e1, int s2, int e2) {
        int p = s1;
        int q = s2;

        int idx = 0;
        while(p<=e1 && q<=e2) {
            if(arr[p] > arr[q]) {
                temp[idx++] = arr[q];
                q++;
            } else {
                temp[idx++] = arr[p];
                p++;
            }
        }

        while(p<=e1) {
            temp[idx++] = arr[p];
            p++;
        }

        while(q<=e2) {
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
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr , mid + 1, end);

        merging(arr, start, mid, mid+1, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        MergeSorting1 m = new MergeSorting1();
        m.mergeSort(arr, 0, n-1);

        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
