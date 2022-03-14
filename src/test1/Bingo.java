package test1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

        Set<String> set = new HashSet<>();
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                for(int a=0; a<5; a++) {
                    for(int b=0; b<5; b++) {
                        if(answerSheet[i][j].equals(bingoSheet[a][b])) {
                            bingoSheet[a][b] = "X";
                        }
                        if(bingoSheet[0][0].equals("X") && bingoSheet[0][1].equals("X") && bingoSheet[0][2].equals("X") && bingoSheet[0][3].equals("X") && bingoSheet[0][4].equals("X")) {
                            set.add("0");
                        }
                        if(bingoSheet[1][0].equals("X") && bingoSheet[1][1].equals("X") && bingoSheet[1][2].equals("X") && bingoSheet[1][3].equals("X") && bingoSheet[1][4].equals("X")) {
                            set.add("1");
                        }
                        if(bingoSheet[2][0].equals("X") && bingoSheet[2][1].equals("X") && bingoSheet[2][2].equals("X") && bingoSheet[2][3].equals("X") && bingoSheet[2][4].equals("X")) {
                            set.add("2");
                        }
                        if(bingoSheet[3][0].equals("X") && bingoSheet[3][1].equals("X") && bingoSheet[3][2].equals("X") && bingoSheet[3][3].equals("X") && bingoSheet[3][4].equals("X")) {
                            set.add("3");
                        }
                        if(bingoSheet[4][0].equals("X") && bingoSheet[4][1].equals("X") && bingoSheet[4][2].equals("X") && bingoSheet[4][3].equals("X") && bingoSheet[4][4].equals("X")) {
                            set.add("4");
                        }
                        if(bingoSheet[0][0].equals("X") && bingoSheet[1][0].equals("X") && bingoSheet[2][0].equals("X") && bingoSheet[3][0].equals("X") && bingoSheet[4][0].equals("X")) {
                            set.add("5");
                        }
                        if(bingoSheet[0][1].equals("X") && bingoSheet[1][1].equals("X") && bingoSheet[2][1].equals("X") && bingoSheet[3][1].equals("X") && bingoSheet[4][1].equals("X")) {
                            set.add("6");
                        }
                        if(bingoSheet[0][2].equals("X") && bingoSheet[1][2].equals("X") && bingoSheet[2][2].equals("X") && bingoSheet[3][2].equals("X") && bingoSheet[4][2].equals("X")) {
                            set.add("7");
                        }
                        if(bingoSheet[0][3].equals("X") && bingoSheet[1][3].equals("X") && bingoSheet[2][3].equals("X") && bingoSheet[3][3].equals("X") && bingoSheet[4][3].equals("X")) {
                            set.add("8");
                        }
                        if(bingoSheet[0][4].equals("X") && bingoSheet[1][4].equals("X") && bingoSheet[2][4].equals("X") && bingoSheet[3][4].equals("X") && bingoSheet[4][4].equals("X")) {
                            set.add("9");
                        }
                        if(bingoSheet[0][0].equals("X") && bingoSheet[1][1].equals("X") && bingoSheet[2][2].equals("X") && bingoSheet[3][3].equals("X") && bingoSheet[4][4].equals("X")) {
                            set.add("!");
                        }
                        if(bingoSheet[4][0].equals("X") && bingoSheet[3][1].equals("X") && bingoSheet[2][2].equals("X") && bingoSheet[1][3].equals("X") && bingoSheet[0][4].equals("X")) {
                            set.add("@");
                        }
                        if(set.size()>=3) {
                            System.out.println(5*i+j+1);
                            return;
                        }
                    }
                }
            }
        }

    }
}
