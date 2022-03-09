package simpleBruteForce;

import java.util.Scanner;

public class Offset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line1 = "10 "+sc.nextLine() + " 10";
        String line2 = "10 "+sc.nextLine()+ " 10";
        String line3 = "10 "+sc.nextLine()+ " 10";
        String line4 = "10 "+sc.nextLine()+ " 10";
        String line5 = "10 "+sc.nextLine()+ " 10";

        String[][] strArray = new String[7][7];
        strArray[0] = new String[]{"10", "10", "10", "10", "10", "10", "10"};
        strArray[1] = line1.split(" ");
        strArray[2] = line2.split(" ");
        strArray[3] = line3.split(" ");
        strArray[4] = line4.split(" ");
        strArray[5] = line5.split(" ");
        strArray[6] = new String[]{"10", "10", "10", "10", "10", "10", "10"};

        Integer[][] intArray = new Integer[7][7];
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                intArray[i][j] = Integer.parseInt(strArray[i][j]);
            }
        }

        for(int i=1; i<6; i++) {
            for(int j=1; j<6; j++) {
                if(intArray[i][j] < intArray[i][j+1] && intArray[i][j] < intArray[i][j-1] && intArray[i][j]< intArray[i-1][j] && intArray[i][j] < intArray[i+1][j]) {
                    strArray[i][j] = "*";
                }
            }
        }

        for(int i=1; i<6; i++) {
            for(int j=1; j<6; j++) {
                System.out.print(strArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
