package test4;

import java.util.Arrays;
import java.util.Scanner;

public class CountNumber {
    public int binarySearchLeft(int[] arr, int s, int e, int value) {
        while(s+1 < e) {
            int mid = (s + e) / 2;
            if(arr[mid] > value) {
                e = mid;
            } else {
                s = mid;
            }
        }
        return s;

    }

    public int binarySearchRight(int[] arr, int s, int e, int value) {
        while(s+1 < e) {
            int mid = (s + e) / 2;
            if(arr[mid] >= value) {
                e = mid;
            } else {
                s = mid;
            }
        }
        return e;

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

        Arrays.sort(numArr);
        CountNumber m = new CountNumber();


        for(int i=0; i<q; i++) {
            if(questionArr[i] == numArr[0]) {
                System.out.println(m.binarySearchLeft(numArr,0, n, questionArr[i]) +1);
            } else {
                System.out.println(m.binarySearchLeft(numArr,0, n, questionArr[i])-m.binarySearchRight(numArr,0, n, questionArr[i])+1);
            }

        }

    }
}
