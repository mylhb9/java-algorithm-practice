package simpleBruteForce;

import java.util.Scanner;

public class AttackRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        String[][] strArray = new String[N][N];

        String[] line = sc.nextLine().split(" ");
        int X = Integer.parseInt(line[0]) - 1;
        int Y = Integer.parseInt(line[1]) - 1;
        int R = Integer.parseInt(line[2]);

        int num = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                num = Math.abs(X-i) + Math.abs(Y-j);
                if(num > R) {
                    num = 0;
                }
                strArray[i][j] = num + " ";
            }
        }
        strArray[X][Y] = "x ";
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(strArray[i][j]);
            }
            System.out.println();
        }

    }
}
