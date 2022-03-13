package part3;

import java.util.Scanner;

public class MaxOfArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] strArr = new String[9][9];
        for(int i=0; i<9; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }
        Integer[][] intArr = new Integer[9][9];
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                intArr[i][j] = Integer.parseInt(strArr[i][j]);
            }
        }

        int max = 0;
        int indexI = 0;
        int indexJ = 0;
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(max < intArr[i][j]) {
                    max = intArr[i][j];
                    indexI = i+1;
                    indexJ = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.println(indexI + " " + indexJ);

    }
}
