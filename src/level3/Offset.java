package level3;

import java.util.Scanner;
public class Offset {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Integer[][] intArr = new Integer[7][7];
        String[][] strArr = new String[5][5];
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                intArr[i][j] = 10;
            }
        }
        for(int i=0; i<5; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                intArr[i+1][j+1] = Integer.parseInt(strArr[i][j]);
            }
        }
        for(int i=1; i<6; i++) {
            for(int j=1; j<6; j++) {
                if(intArr[i][j] < intArr[i-1][j] && intArr[i][j] < intArr[i+1][j] && intArr[i][j] < intArr[i][j-1] && intArr[i][j] < intArr[i][j+1]) {
                    strArr[i-1][j-1] = "*";
                }
            }
        }
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                System.out.print(strArr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
