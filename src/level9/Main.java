package level9;

import java.util.Scanner;

// 문제: n개의 정수가 주어질 떄, 이를 합병정렬을 이용하여 오름차순으로 정렬하는 프로그램을 작성
// 입력: 첫 번째 줄에 n이 주어진다. (1 <= n <= 100,000) 두번째 줄에 n개의 정수가 주어진다.
// 출력: 첫 번째 줄에 n개의 숫자를 합병정렬을 이용하여 오름차순으로 정렬한 결과를 출력
public class Main {
    Integer[] leftArr = new Integer[100001];
    Integer[] rightArr = new Integer[100001];

    public void merging() {

    }

    public void mergeSort(Integer[] arr, int start, int end) {
        if(start >= end) {
            return;
        } else {
            int mid = (start + end) / 2;

            mergeSort(arr, start , mid);
            mergeSort(arr, mid+1, end);


        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


    }
}
