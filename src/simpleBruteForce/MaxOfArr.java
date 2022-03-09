package simpleBruteForce;

import java.util.ArrayList;
import java.util.List;
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
        List<Integer> indexI = new ArrayList<>();
        List<Integer> indexJ = new ArrayList<>();
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(max < intArr[i][j]) {
                    max = intArr[i][j];
                }
            }
        }

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(intArr[i][j] == max) {
                    indexI.add(i+1);
                    indexJ.add(j+1);
                }
            }
        }

        int min = 100;
        int minIndex = 0;
        for(int i=0; i<indexJ.size(); i++) {
            if(indexJ.get(i) < min) {
                min = indexJ.get(i);
            }
        }
        for(int i=0; i<indexJ.size(); i++) {
            if(indexJ.get(i)==min) {
                minIndex = i;
            }
        }


        System.out.println(max);
        System.out.println(indexI.get(minIndex) + " " + min);

    }
}
