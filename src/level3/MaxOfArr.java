package level3;

import java.util.Scanner;

public class MaxOfArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] inputArr = new String[9][9];
        for(int i=0; i<9; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }
        Integer[][] intArr = new Integer[9][9];
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                intArr[i][j] = Integer.parseInt(inputArr[i][j]);
            }
        }

        int mx = 0;
        int x = 0;
        int y = 0;
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(mx < intArr[i][j]) {
                    mx = intArr[i][j];
                    x = i+1;
                    y = j+1;
                }
            }
        }

        System.out.println(mx);
        System.out.println(x + " " + y);
    }
}
