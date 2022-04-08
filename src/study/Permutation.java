package study;

import java.util.Scanner;

public class Permutation {
    int n, m;
    boolean[] visited;
    Integer[] arr;
    void recur(int x) {
        if(x == n) {
            for(int i=0; i<n; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        } else {
            for(int i=0; i<m; i++) {
                if(visited[i]) {
                    continue;
                }

                visited[i] = true;
                arr[x] = i;
                recur(x+1);
                visited[i] = false;


            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        Permutation main = new Permutation();
        main.m = m;
        main.n = n;
        main.visited = new boolean[n+1];
        main.arr = new Integer[n+1];
        main.recur(0);
    }
}
