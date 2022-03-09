package simpleBruteForce;

import java.util.Scanner;

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
            for(int j=0; j<5; j++) {
                bingoSheet[i][j] = Integer.parseInt(stringBingoSheet[i][j]);
            }
        }
        for(int i=0; i<5; i++) {
            stringBingoAnswer[i] = sc.nextLine().split(" ");
        }
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                bingoAnswer[i][j] = Integer.parseInt(stringBingoAnswer[i][j]);
            }
        }


        int count = 0;
        int check = 0;
        boolean checked1 = false;
        boolean checked2 = false;
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    for(int l=0; l<5; l++) {
                        if(bingoSheet[i][j] == (bingoAnswer[k][l])) {
                            bingoSheet[i][j] = 0;
                            count++;
                        }


                        if(!checked1) {
                            if(bingoSheet[4][0] + bingoSheet[3][1] + bingoSheet[2][2] + bingoSheet[1][3] + bingoSheet[0][4] == 0) {
                                checked1 = true;
                                check++;
                            }
                        }
                        if(!checked2) {
                            if(bingoSheet[0][0] + bingoSheet[1][1] + bingoSheet[2][2] + bingoSheet[3][3] + bingoSheet[4][4] == 0) {
                                checked2 = true;
                                check++;
                            }
                        }
                        if(check >= 3) {
                            System.out.println(count);
                            return;
                        }
                    }
                }
                if(bingoSheet[0][j] + bingoSheet[1][j] + bingoSheet[2][j] + bingoSheet[3][j] + bingoSheet[4][j] == 0) {
                    check++;
                }
            }
            if(bingoSheet[i][0] + bingoSheet[i][1] + bingoSheet[i][2] + bingoSheet[i][3] + bingoSheet[i][4] == 0) {
                check++;
            }
        }


        for(int k=0; k<5; k++) {
            for(int l=0; l<5; l++) {
                System.out.print(bingoSheet[k][l] + " ");
            }
            System.out.println();
        }
    }
}
