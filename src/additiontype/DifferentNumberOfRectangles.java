package additiontype;

import java.util.Scanner;

public class DifferentNumberOfRectangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

//        boolean[] checkArr = new boolean[11];
        int[] checkCountArr = new int[11];
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                int a = sc.nextInt();
                checkCountArr[a]++;
                arr[i][j] = checkCountArr[a];

            }
        }

        // 0 0 0
        // 1 1 1
        // 1 1 3

        // 3  2  10
        // 3  7   1
        // 1  10  9



        int Q = sc.nextInt();
        int[][] qArr = new int[Q][4];
        int count = 0;
        for(int i=0; i<Q; i++) {
            qArr[i][0] = sc.nextInt(); // x1
            qArr[i][1] = sc.nextInt(); // y1
            qArr[i][2] = sc.nextInt(); // x2
            qArr[i][3] = sc.nextInt(); // y2


            for(int j=1; j<=10; j++) {
                if(checkCountArr[j] == 1) {
                    count++;
                }
            }


        }


        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
