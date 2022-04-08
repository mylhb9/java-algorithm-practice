package level8;

import java.util.Scanner;

public class Division1 {
    int n, m;
    int count = 0;
    Integer[] arr;
    void recur(int x, int start, int sum) {
        if(sum > n || x > n) {
            return;
        }
        if(sum == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if(arr[i] != null && arr[i] != 0) {
                    if(arr[i+1] == null || arr[i+1] == 0) {
                        sb.append(arr[i]);
                    } else {
                        sb.append(arr[i] + "+");
                    }


                }
            }
            System.out.println(sb);
            count++;
        } else {
            for(int i=start; i>=0; i--) {
                arr[x] = i;
                sum+=i;
                recur(x+1, i, sum);
                sum-=i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Division1 main = new Division1();
        main.n = n;
        main.m = n;
        main.arr = new Integer[n+1];
        main.recur(0, n-1, 0);
        System.out.println(main.count);
    }
}
