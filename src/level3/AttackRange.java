package level3;

import java.util.*;

public class AttackRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] inputArr = sc.nextLine().split(" ");
        int x = Integer.parseInt(inputArr[0]) - 1;
        int y = Integer.parseInt(inputArr[1]) - 1;
        int r = Integer.parseInt(inputArr[2]);

        String[][] answerArr = new String[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i == x && j == y) {
                    answerArr[i][j] = "x";
                } else if(Math.abs(i-x) + Math.abs(j-y) <= r) {
                    answerArr[i][j] = String.valueOf(Math.abs(i-x) + Math.abs(j-y));
                } else {
                    answerArr[i][j] = "0";
                }
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(answerArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
