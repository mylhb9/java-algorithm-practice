package study;

import java.util.Scanner;

public class DuplicatePermutation {
    int n,m;
    Integer[] arr;
    void recur(int x) {
        if(x == n) {
            for(int i=0; i<n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for(int i=0; i<m; i++) {
                arr[x] = i;
                recur(x+1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);

        DuplicatePermutation main = new DuplicatePermutation();
        main.arr = new Integer[n+1];
        main.n = n;
        main.m = m;
        main.recur(0);
    }
}
