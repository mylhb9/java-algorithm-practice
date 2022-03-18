package level3;

import java.util.Scanner;

public class FlipMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[][] intArr = new Integer[10][10];
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                intArr[i][j] = 0;
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<10; j++) {
                if(intArr[i][j] == 0) {
                    intArr[i][j] = 1;
                } else {
                    intArr[i][j] = 0;
                }
            }
        }
        for(int j=0; j<N; j++) {
            for(int i=0; i<10; i++) {
                if(i==j) {
                    continue;
                }
                if(intArr[i][j] == 0) {
                    intArr[i][j] = 1;
                } else {
                    intArr[i][j] = 0;
                }
            }
        }


        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                System.out.print(intArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}