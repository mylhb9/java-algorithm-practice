package level3;

import java.util.Scanner;

public class FlipMatrix2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[][] inputArr = new String[10][10];

        for(int i=0; i<10; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<10; j++) {
                if(inputArr[i][j].equals("1")) {
                    inputArr[i][j] = "0";
                } else {
                    inputArr[i][j] = "1";
                }
            }
        }
        for(int j=0; j<N; j++) {
            for(int i=0; i<10; i++) {
                if(i==j) {
                    continue;
                }
                if(inputArr[i][j].equals("1")) {
                    inputArr[i][j] = "0";
                } else {
                    inputArr[i][j] = "1";
                }
            }
        }

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++) {
                System.out.print(inputArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
