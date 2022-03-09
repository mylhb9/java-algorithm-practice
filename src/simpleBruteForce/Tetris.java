package simpleBruteForce;

import java.util.Scanner;

public class Tetris {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int col = Integer.parseInt(line[0]);
        int row = Integer.parseInt(line[1]);

        String[][] strArray = new String[row][col];
        Integer[][] intArray = new Integer[row][col];
        for(int i=0; i<row; i++) {
            strArray[i] = sc.nextLine().split(" ");
        }


        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                intArray[i][j] = Integer.parseInt(strArray[i][j]);
            }
        }

        int selectedCol = 0;
        for(int j=0; j<col; j++) {
            int sum = 0;
            int check = 0;
            for(int i=0; i<row; i++) {
                sum += intArray[i][j];
                if(sum == 0) {
                    check++;
                }
                if(check >= row) {
                    selectedCol = j;
                }
            }
        }
        int count = 0;
        for(int i=0; i<row; i++) {
            int sum = 0;
            for(int j=0; j<col; j++) {
                sum += intArray[i][j];
                if(sum == col - 1 && intArray[i][selectedCol] == 0) {
                    count++;
                }
            }
        }
        System.out.println(selectedCol+1 + " " + count);
    }
}
