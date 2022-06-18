package newPart12;

import java.util.Scanner;

public class BinarySearchRecurEx {

    public static int binarySearch(int[] arr, int start, int end, int value) {
        // arr의 start부터 end까지 값들 중에서
        // value가 존재한다면 그 위치를 반환하고,
        // 그렇지 않다면 -1을 반환하는 함수

        if(start > end) {
            return -1;
        } else if(start == end) {
            if(arr[start] == value) {
                return start;
            } else {
                return -1;
            }
        } else {
            int mid = (start + end) / 2;
            if(arr[mid] == value) {
                return mid;
            } else if(arr[mid] > value) {
                return binarySearch(arr, start, mid - 1, value);
            } else {
                return binarySearch(arr, mid+1, end, value);
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[100];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int idx = binarySearch(arr, 0, n-1, m);

        if(idx == -1) {
            System.out.println("수가 없습니다");
        } else {
            System.out.println(idx+"번째에 숫자가 있습니다.");
        }
    }
}
