package newPart12;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int binarySearchBack(int[] arr, int start, int end, int value) {
        while(start+1<end) {
            int mid = (start + end) / 2;
            if(arr[mid] > value) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }
    public static int binarySearchFront(int[] arr, int start, int end, int value) {
        while(start+1<end) {
            int mid = (start+end) / 2;
            if(arr[mid] >= value) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int[] questions = new int[100005];
        for(int i=0; i<q; i++) {
            questions[i] = sc.nextInt();

        }
        for(int i=0; i<q; i++) {
            System.out.println(binarySearchBack(arr, -1, n, questions[i]) - binarySearchFront(arr, -1, n, questions[i]) + 1);
        }

        sc.close();
    }
}
