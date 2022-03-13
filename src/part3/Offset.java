package part3;

import java.util.Scanner;

public class Offset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] strArray = new String[5][5];
        for(int i=0; i<5; i++) {
            strArray[i] = sc.nextLine().split(" ");
        }
        Integer[][] intArray = new Integer[7][7];
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                intArray[i][j] = 10;
            }
        }

        for(int i=1; i<6; i++) {
            for(int j=1; j<6; j++) {
                intArray[i][j] = Integer.parseInt(strArray[i-1][j-1]);
            }
        }


        for(int i=1; i<6; i++) {
            for(int j=1; j<6; j++) {
                if(intArray[i][j] < intArray[i+1][j] && intArray[i][j] < intArray[i-1][j] && intArray[i][j] < intArray[i][j+1] && intArray[i][j] < intArray[i][j-1]) {
                    strArray[i-1][j-1] = "*";
                }
            }
        }
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                System.out.print(strArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
