package part12;

// 문제: n개의 오름차순으로 정렬된 숫자가 주어지고, 그 후 q 개의 질문이 주어진다.
// 각각의 질문은 특정 숫자가 n개의 숫자 내에 존재하는지를 판별하는 것이다.
// 모든 q개의 질문에 대하여 답을 하는 프로그램을 작성하시오

// 입력: 첫 번째 줄에 숫자의 개수 n, 그리고 질문의 개수 q가 주어진다.
// 두 번째 줄에 n개의 숫자가 주어진다.
// 세 번째 줄에 q개의 질문이 주어진다.

// 출력: 각 질문에 대하여 숫자가 존재하면 YES, 아니면 NO를 한줄에 하나씩 출력한다.

import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] arr, int s, int e, int value) {
        if(s > e) {
            return -1;
        } else if(s == e) {
            if(arr[s] == value) {
                return s;
            } else {
                return -1;
            }
        }


        int mid = (s + e) / 2;
        if(arr[mid] > value) {
            return binarySearch(arr, s, mid-1, value);
        } else if(arr[mid] == value) {
            return mid;
        } else {
            return binarySearch(arr, mid+1, e, value);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] numArr = new int[n];
        int[] questionArr = new int[q];

        for(int i=0; i<n; i++) {
            numArr[i] = sc.nextInt();
        }

        for(int i=0; i<q; i++) {
            questionArr[i] = sc.nextInt();
        }
        for(int i=0; i<q; i++) {
            if(binarySearch(numArr, 0, n-1, questionArr[i]) == -1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
