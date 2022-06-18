package newPart12;

import java.util.Scanner;

public class BinarySearchWhileEx {
    public static int binarySearch(int[] arr, int start, int end, int value) {
        // arr의 start 부터 end 까지 중에서
        // value 를 찾아 그 위치를 반환하는 함수
        // 만약, 없다면 -1을 반환한다.


        if(arr[start] > value) {
            return -1;
        } else if(arr[start] == value) {
            return start;
        }
        if(arr[end] < value) {
            return -1;
        } else if(arr[end] == value) {
            return end;
        }

        while(start + 1 < end) {
            int mid = (start + end) / 2;
            if(arr[mid] == value) {
                return mid;
            } else if(arr[mid] > value) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[100];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int idx = binarySearch(arr ,0 ,n-1, m);
        if(idx == -1) {
            System.out.println("수를 찾을 수 없습니다.");
        } else {
            System.out.println(idx+"번째에 있습니다.");
        }

    }
}
