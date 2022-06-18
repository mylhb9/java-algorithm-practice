package newPart12;

import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] arr, int start, int end, int value) {
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
            } else if(arr[mid] < value) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] questions = new int[q];
        for(int i=0; i<q; i++) {
            questions[i] = sc.nextInt();
        }
        for(int i=0; i<q; i++) {
            if(binarySearch(arr, 0, n-1, questions[i]) == -1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        sc.close();
    }
}
