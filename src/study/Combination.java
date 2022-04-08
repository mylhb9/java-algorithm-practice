package study;

import java.util.Scanner;

public class Combination {
    int n, m;
    Integer[] arr;
    boolean[] visited;
    void recur(int x, int start) {
        if(x == n) {
            for(int i=0; i<n; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        } else {
            for(int i=start; i<m; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    arr[x] = i;
                    recur(x+1, i+1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Combination main = new Combination();
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());

        main.n = n;
        main.m = m;
        main.visited = new boolean[n+1];
        main.arr = new Integer[n+1];

        main.recur(0, 0);
    }
}
