package test5;

import java.util.Scanner;

public class Offset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[7][7];
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                if(i==0 || i==6 || j==0 || j==6) {
                    arr[i][j] = 10;
                } else {
                    arr[i][j] = sc.nextInt();
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        String[][] answerArr = new String[5][5];
        for(int i=1; i<6; i++) {
            for(int j=1; j<6; j++) {
                answerArr[i-1][j-1] = String.valueOf(arr[i][j]);
                boolean check = false;
                for(int k=0; k<4; k++) {
                    if(arr[i+dx[k]][j+dy[k]] <= arr[i][j]) {
                        check = true;
                    }
                }
                if(!check) {
                    answerArr[i-1][j-1] = "*";
                }
            }
        }

        for(int i=1; i<6; i++) {
            for(int j=1; j<6; j++) {
                System.out.print(answerArr[i-1][j-1] + " ");
            }
            System.out.println();
        }


    }
}
