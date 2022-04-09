package part6;

import java.util.Arrays;
import java.util.Scanner;

public class Division2 {
    int n;
    boolean[] visited;
    Integer[] arr;
    int count = 0;
    void recur(int x, int sum, int start) {
        if(sum > n || x>n) {
            return;
        }

        if(sum == n) {
            for(int i=0; i<n; i++) {
                if(arr[i] != null) {
                    if(arr[i+1] == null) {
                        System.out.print(arr[i]);
                    } else {
                        System.out.print(arr[i]+"+");
                    }
                }
            }
            count++;
            System.out.println();
        } else {
            for(int i=start; i>=1; i--) {
                arr[x] = i;
                sum += i;
                recur(x+1, sum, start);
                sum -= i;
                arr[x] = null;
                start-=1;
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Division2 m = new Division2();
        m.n = n;
        m.visited = new boolean[21];
        Arrays.fill(m.visited, false);
        m.arr = new Integer[21];
        m.recur(0, 0, n-1);
        System.out.println(m.count);
    }
}
