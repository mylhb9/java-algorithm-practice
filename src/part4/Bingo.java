package part4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bingo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] stringBingoSheet = new String[5][5];
        Integer[][] bingoSheet = new Integer[5][5];
        String[][] stringBingoAnswer = new String[5][5];
        Integer[][] bingoAnswer = new Integer[5][5];

        for(int i=0; i<5; i++) {
            stringBingoSheet[i] = sc.nextLine().split(" ");
        }
        for(int i=0; i<5; i++) {
            stringBingoAnswer[i] = sc.nextLine().split(" ");
        }
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                bingoSheet[i][j] = Integer.parseInt(stringBingoSheet[i][j]);
                bingoAnswer[i][j] = Integer.parseInt(stringBingoAnswer[i][j]);
            }
        }

        Set<String> set = new HashSet<>();

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                for(int a=0; a<5; a++) {
                    for(int b=0; b<5; b++) {
                        if(bingoSheet[a][b].equals(bingoAnswer[i][j])) {
                            bingoSheet[a][b] = 0;
                        }
                        if(bingoSheet[0][0] + bingoSheet[0][1] + bingoSheet[0][2] + bingoSheet[0][3] + bingoSheet[0][4] == 0) {
                            set.add("1");
                        }
                        if(bingoSheet[1][0] + bingoSheet[1][1] + bingoSheet[1][2] + bingoSheet[1][3] + bingoSheet[1][4] == 0) {
                            set.add("2");
                        }
                        if(bingoSheet[2][0] + bingoSheet[2][1] + bingoSheet[2][2] + bingoSheet[2][3] + bingoSheet[2][4] == 0) {
                            set.add("3");
                        }
                        if(bingoSheet[3][0] + bingoSheet[3][1] + bingoSheet[3][2] + bingoSheet[3][3] + bingoSheet[3][4] == 0) {
                            set.add("4");
                        }
                        if(bingoSheet[4][0] + bingoSheet[4][1] + bingoSheet[4][2] + bingoSheet[4][3] + bingoSheet[4][4] == 0) {
                            set.add("5");
                        }
                        if(bingoSheet[0][0] + bingoSheet[1][0] + bingoSheet[2][0] + bingoSheet[3][0] + bingoSheet[4][0] == 0) {
                            set.add("6");
                        }
                        if(bingoSheet[0][1] + bingoSheet[1][1] + bingoSheet[2][1] + bingoSheet[3][1] + bingoSheet[4][1] == 0) {
                            set.add("7");
                        }
                        if(bingoSheet[0][2] + bingoSheet[1][2] + bingoSheet[2][2] + bingoSheet[3][2] + bingoSheet[4][2] == 0) {
                            set.add("8");
                        }
                        if(bingoSheet[0][3] + bingoSheet[1][3] + bingoSheet[2][3] + bingoSheet[3][3] + bingoSheet[4][3] == 0) {
                            set.add("9");
                        }
                        if(bingoSheet[0][4] + bingoSheet[1][4] + bingoSheet[2][4] + bingoSheet[3][4] + bingoSheet[4][4] == 0) {
                            set.add("0");
                        }
                        if(bingoSheet[0][0] + bingoSheet[1][1] + bingoSheet[2][2] + bingoSheet[3][3] + bingoSheet[4][4] == 0) {
                            set.add("#");
                        }
                        if(bingoSheet[4][0] + bingoSheet[3][1] + bingoSheet[2][2] + bingoSheet[1][3] + bingoSheet[0][4] == 0) {
                            set.add("&");
                        }
                        if(set.size()>=3) {
                            System.out.println(set);
                            System.out.println(i * 5 + j + 1);
                            return;
                        }
                    }
                }
            }
        }

    }
}
