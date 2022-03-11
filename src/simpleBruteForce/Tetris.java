package simpleBruteForce;

import java.util.ArrayList;
import java.util.List;
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

        List<Integer> rowList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        for(int j=0; j<col; j++) {
            for(int i=0; i<row; i++) {
                if(intArray[i][j] == 1) {
                    rowList.add(i);
                    break;
                }
            }

            if(rowList.get(j) >= 4) {
                for(int k=1; k<=4; k++) {
                    intArray[j][rowList.get(j) - k] = 1;
                }
                int count = 0;
                for(int p=0; p<row; p++) {
                    for(int q=0; q<col; q++) {
                        if(intArray[p][q] >= col) {
                            count++;
                            maxList.add(count);
                        }
                    }
                }
            }

        }

        for(int i=0; i<rowList.size(); i++) {
            System.out.println(rowList.get(i));
        }

        for(int i=0; i<maxList.size(); i++) {
            System.out.println(maxList.get(i));
        }

    }
}
