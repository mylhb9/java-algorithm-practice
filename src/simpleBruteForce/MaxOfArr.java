package simpleBruteForce;

import java.util.Scanner;

public class MaxOfArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] strArr = new String[9][9];
        Integer[][] intArr = new Integer[9][9];
        for(int i=0; i<9; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                intArr[i][j] = Integer.parseInt(strArr[i][j]);
            }
        }

        int max = 0;
        int x = 0;
        int y = 0;
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(intArr[i][j] > max) {
                    max = intArr[i][j];
                    x = i+1;
                    y = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.println(x+ " " + y);
    }
}
