package array;

import java.util.Scanner;
public class DiceGame {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] stringLine = new String[n];
        String[][] stringIntegerLine = new String[n][3];
        Integer[][] integerLine = new Integer[n][3];
        Integer[] maxValues = new Integer[n];
        for(int i=0; i<n; i++) {
            maxValues[i] = 0;
        }

        for(int i=0; i<n; i++) {
            stringLine[i] = sc.nextLine();
            for(int j=0; j<3; j++) {
                stringIntegerLine[i] = stringLine[i].split(" ");
                integerLine[i][j] = Integer.parseInt(stringIntegerLine[i][j]);
            }
            if(integerLine[i][0] == integerLine[i][1] && integerLine[i][1] == integerLine[i][2]) {
                maxValues[i] = 10000 + integerLine[i][0] * 1000;
            } else if(integerLine[i][0] != integerLine[i][1] && integerLine[i][1] != integerLine[i][2] && integerLine[i][0] != integerLine[i][2]) {
                int max = integerLine[i][0];
                if(max < integerLine[i][1]) {
                    max = integerLine[i][1];
                }
                if(max < integerLine[i][2]) {
                    max = integerLine[i][2];
                }
                maxValues[i] = max * 100;
            } else {
                int same = integerLine[i][0];
                if(same != integerLine[i][1]) {
                    same = integerLine[i][1];
                }
                maxValues[i] = 1000 + same * 100;
            }
        }
        int maxPrice = 0;
        for(int i=0; i<n; i++) {
            if(maxPrice < maxValues[i]) {
                maxPrice = maxValues[i];
            }
        }
        System.out.println(maxPrice);


    }
}
