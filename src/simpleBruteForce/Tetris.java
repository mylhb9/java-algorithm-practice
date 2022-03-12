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
        for (int i = 0; i < row; i++) {
            strArray[i] = sc.nextLine().split(" ");
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                intArray[i][j] = Integer.parseInt(strArray[i][j]);
            }
        }

        Integer[] first1s = new Integer[col];
        for(int j=0; j<col; j++) {
            for(int i=0; i<row; i++) {
                if(intArray[i][j] == 1) {
                    first1s[j] = i;
                    break;
                }
            }
            if(first1s[j] == null) {
                first1s[j] = row;
            }
        }




        List<Integer> possibleCol = new ArrayList<>();

        for(int i=0; i<col; i++) {
            if(first1s[i] >= 4) {
                possibleCol.add(i);
            }
        }

        List<Integer> countList  = new ArrayList<>();

        for(int i=0; i<possibleCol.size(); i++) {
            int N = possibleCol.get(i);
            for(int j=first1s[possibleCol.get(i)]-4; j<first1s[possibleCol.get(i)]; j++) {
                intArray[j][N] = 1;
            }
            int count = 0;
            for(int a=0; a<row; a++) {
                int sum = 0;

                for(int b=0; b<col; b++) {
                    sum += intArray[a][b];
                    if(sum == col) {
                        count++;

                    }
                }
            }
            countList.add(count);
            for(int j=row-4; j<row; j++) {
                intArray[j][N] = 0;
            }
        }
        int value = 0;
        int index = 0;
        for(int i=0; i<countList.size(); i++) {
            if(value < countList.get(i)) {
                value = countList.get(i);
                index = i;
            }
        }

        if(value == 0) {
            System.out.println(0 + " " + value);
        } else {
            System.out.println(possibleCol.get(index) + 1 + " " + value);
        }

    }
}
