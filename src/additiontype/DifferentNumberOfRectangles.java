package additiontype;

import java.util.Scanner;

public class DifferentNumberOfRectangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] saveArr= new int[301][301];
        int[][][] arr = new int[301][301][11];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                saveArr[i][j] = sc.nextInt();
                if(i==0 || j==0) {
                    if(i==0 && j==0) {

                    } else if(i == 0) {
                        for(int k=0; k<10; k++) {
                            arr[i][j][k] = arr[i][j-1][k];
                        }
                    } else {
                        for(int k=0; k<10; k++) {
                            arr[i][j][k] = arr[i-1][j][k];
                        }
                    }

                } else {
                    arr[i][j][saveArr[i-1][j]]++;
                    for(int k=0; k<10; k++) {
                        arr[i][j][k] = arr[i][j-1][k] + arr[i-1][j][k];
                    }
                }
                arr[i][j][saveArr[i][j]]++;

            }
        }

        // 0 0 0
        // 1 1 1
        // 1 1 3

        // 3  2  10
        // 3  7   1
        // 1  10  9


        int Q = sc.nextInt();
        int[][] answerArr = new int[Q][4];
        for(int i=0; i<Q; i++) {
            answerArr[i][0]= sc.nextInt();
            answerArr[i][1]= sc.nextInt();
            answerArr[i][2]= sc.nextInt();
            answerArr[i][3]= sc.nextInt();
        }

        for(int i=0; i<Q; i++) {
            for(int j=0; j<10; j++) {

            }
        }

    }
}
