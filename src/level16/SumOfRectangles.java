package level16;

import java.util.Scanner;

public class SumOfRectangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N x M 직사각형
        int N = sc.nextInt();
        int M = sc.nextInt();
        // Q는 질문의 개수이다
        int Q = sc.nextInt();

        int[][] newArr = new int[N][M];
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=0; j<M; j++) {
                sum += sc.nextInt();
                if(i>0) {
                    newArr[i][j] = sum + newArr[i-1][j];
                } else {
                    newArr[i][j] = sum;
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
            if(a[i] == 0 && b[i] == 0) {
                System.out.println(newArr[c[i]][d[i]]);
            } else if(a[i] == 0) {
                System.out.println(newArr[c[i]][d[i]] - newArr[c[i]][b[i]-1]);
            } else if(b[i] == 0) {
                System.out.println(newArr[c[i]][d[i]] - newArr[a[i]-1][d[i]]);
            } else {
                System.out.println(newArr[c[i]][d[i]] + newArr[a[i]-1][b[i]-1] - newArr[a[i]-1][d[i]] - newArr[c[i]][b[i]-1]);
            }
        }
    }
}
