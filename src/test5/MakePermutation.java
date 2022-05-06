package test5;

import java.util.Scanner;

public class MakePermutation {
    int n;
    int r;
    char[] arr = new char[11];
    boolean[] visited = new boolean[11];
    public void getResult(int x) {
        if(x >= r) {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<r; i++) {
                sb.append(arr[i]);
            }
            System.out.println(sb);
        } else {
            for(int i=0; i<n; i++) {
                char pivot = (char) ('a' + i);
                if(!visited[i]) {
                    arr[x] = pivot;
                    visited[i] = true;
                    getResult(x+1);
                    arr[x] = 0;
                    visited[i] = false;
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        MakePermutation m = new MakePermutation();
        m.n = n;
        m.r = r;
        m.getResult(0);
    }
}
