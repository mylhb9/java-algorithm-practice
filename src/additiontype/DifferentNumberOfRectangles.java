package additiontype;

import java.util.Scanner;

public class DifferentNumberOfRectangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][][] arr = new int[301][301][11];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int a = sc.nextInt();
                if(i==0 && j==0) {
                    arr[i][j][a]++;
                } else if(i==0) {
                    for(int k=1; k<=10; k++) {
                        arr[i][j][k] = arr[i][j-1][k];
                    }
                    arr[i][j][a]++;
                } else {
                    for(int k=1; k<=10; k++) {
                        if(j==0) {
                            arr[i][j][k] = arr[i-1][j][k];
                        } else {
                            arr[i][j][k] = arr[i-1][j][k] + arr[i][j-1][k] - arr[i-1][j-1][k];
                        }
                    }
                    arr[i][j][a]++;
                }
            }
        }




        // 3  2  10
        // 3  7   1
        // 1  10  9


        int Q = sc.nextInt();
        int[][] answerArr = new int[Q][4];
        for(int i=0; i<Q; i++) {
            answerArr[i][0]= sc.nextInt()-1;
            answerArr[i][1]= sc.nextInt()-1;
            answerArr[i][2]= sc.nextInt()-1;
            answerArr[i][3]= sc.nextInt()-1;
        }

        for(int i=0; i<Q; i++) {
            int total = (answerArr[i][2]-answerArr[i][0]+1)*(answerArr[i][3]-answerArr[i][1]+1);
            int count = 0;
            for(int j=1; j<=10; j++) {
                if(answerArr[i][0] == 0 && answerArr[i][1] == 0) {
                    if(arr[answerArr[i][2]][answerArr[i][3]][j] >= 1) {
                        count += 1;
                    }
                } else if(answerArr[i][0] == 0) {
                    if(arr[answerArr[i][2]][answerArr[i][3]][j]  - arr[answerArr[i][2]][answerArr[i][1]-1][j] >= 1) {
                        count += 1;
                    }
                } else if(answerArr[i][1] == 0) {
                    if(arr[answerArr[i][2]][answerArr[i][3]][j] - arr[answerArr[i][0]-1][answerArr[i][3]][j] >= 1) {
                        count += 1;
                    }
                } else {
                    if(arr[answerArr[i][2]][answerArr[i][3]][j] - arr[answerArr[i][0]-1][answerArr[i][3]][j] - arr[answerArr[i][2]][answerArr[i][1]-1][j] + arr[answerArr[i][0]-1][answerArr[i][1]-1][j] >= 1) {
                        count += 1;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
