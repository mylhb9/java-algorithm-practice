package additiontype;

import java.util.Scanner;

public class SumOfRectangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();

        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++) {
            int sum =0 ;
            for(int j=0; j<M; j++) {
                int a = sc.nextInt();
                sum += a;
                if(i==0) {
                    arr[i][j] = sum;
                } else {
                    arr[i][j] = arr[i-1][j] + sum;
                }
            }
        }

        int[] a = new int[Q];
        int[] b = new int[Q];
        int[] c = new int[Q];
        int[] d = new int[Q];

        for(int i=0; i<Q; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        for(int i=0; i<Q; i++) {
            if(a[i] >= 1 && b[i] >= 1) {
                System.out.println(arr[c[i]][d[i]] - arr[c[i]][b[i]-1] - arr[a[i]-1][d[i]] + arr[a[i]-1][b[i]-1]);
            } else if(b[i] >= 1) {
                System.out.println(arr[c[i]][d[i]] - arr[c[i]][b[i]-1]);
            } else if(a[i] >= 1) {
                System.out.println(arr[c[i]][d[i]] - arr[a[i]-1][d[i]]);
            } else {
                System.out.println(arr[c[i]][d[i]]);
            }
        }
        sc.close();
    }
}