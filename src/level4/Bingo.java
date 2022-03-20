package level4;

import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] bingoSheet = new String[5][5];
        String[][] answerSheet = new String[5][5];

        for(int i=0; i<5; i++) {
            bingoSheet[i] = sc.nextLine().split(" ");
        }
        for(int i=0; i<5; i++) {
            answerSheet[i] = sc.nextLine().split(" ");
        }

        int x = 0;
        int y = 0;
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                for(int p=0; p<5; p++) {
                    for(int q=0; q<5; q++) {
                        if(bingoSheet[p][q].equals(answerSheet[i][j])) {
                            bingoSheet[p][q] = "x";
                        }
                        int count = 0;
                        if(bingoSheet[0][0].equals("x") && bingoSheet[0][1].equals("x") && bingoSheet[0][2].equals("x") && bingoSheet[0][3].equals("x") && bingoSheet[0][4].equals("x")) {
                            count++;
                        }
                        if(bingoSheet[1][0].equals("x") && bingoSheet[1][1].equals("x") && bingoSheet[1][2].equals("x") && bingoSheet[1][3].equals("x") && bingoSheet[1][4].equals("x")) {
                            count++;
                        }
                        if(bingoSheet[2][0].equals("x") && bingoSheet[2][1].equals("x") && bingoSheet[2][2].equals("x") && bingoSheet[2][3].equals("x") && bingoSheet[2][4].equals("x")) {
                            count++;
                        }
                        if(bingoSheet[3][0].equals("x") && bingoSheet[3][1].equals("x") && bingoSheet[3][2].equals("x") && bingoSheet[3][3].equals("x") && bingoSheet[3][4].equals("x")) {
                            count++;
                        }
                        if(bingoSheet[4][0].equals("x") && bingoSheet[4][1].equals("x") && bingoSheet[4][2].equals("x") && bingoSheet[4][3].equals("x") && bingoSheet[4][4].equals("x")) {
                            count++;
                        }
                        if(bingoSheet[0][0].equals("x") && bingoSheet[1][0].equals("x") && bingoSheet[2][0].equals("x") && bingoSheet[3][0].equals("x") && bingoSheet[4][0].equals("x")) {
                            count++;
                        }
                        if(bingoSheet[0][1].equals("x") && bingoSheet[1][1].equals("x") && bingoSheet[2][1].equals("x") && bingoSheet[3][1].equals("x") && bingoSheet[4][1].equals("x")) {
                            count++;
                        }
                        if(bingoSheet[0][2].equals("x") && bingoSheet[1][2].equals("x") && bingoSheet[2][2].equals("x") && bingoSheet[3][2].equals("x") && bingoSheet[4][2].equals("x")) {
                            count++;
                        }
                        if(bingoSheet[0][3].equals("x") && bingoSheet[1][3].equals("x") && bingoSheet[2][3].equals("x") && bingoSheet[3][3].equals("x") && bingoSheet[4][3].equals("x")) {
                            count++;
                        }
                        if(bingoSheet[0][4].equals("x") && bingoSheet[1][4].equals("x") && bingoSheet[2][4].equals("x") && bingoSheet[3][4].equals("x") && bingoSheet[4][4].equals("x")) {
                            count++;
                        }
                        if(bingoSheet[0][0].equals("x") && bingoSheet[1][1].equals("x") && bingoSheet[2][2].equals("x") && bingoSheet[3][3].equals("x") && bingoSheet[4][4].equals("x")) {
                            count++;
                        }
                        if(bingoSheet[4][0].equals("x") && bingoSheet[3][1].equals("x") && bingoSheet[2][2].equals("x") && bingoSheet[1][3].equals("x") && bingoSheet[0][4].equals("x")) {
                            count++;
                        }
                        if(count >= 3) {
                            x = i;
                            y = j;
                            System.out.println(5 * x + y + 1);
                            return;
                        }

                    }
                }
            }
        }

    }
}