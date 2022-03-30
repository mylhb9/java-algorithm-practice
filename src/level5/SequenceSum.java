package level5;

import java.util.Scanner;

public class SequenceSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        String[][] strTableS = new String[N][N];
        for(int i=0; i<N; i++) {
            strTableS[i] = sc.nextLine().split(" ");
        }

        // tableS 만들기
        Integer[][] tableS = new Integer[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                tableS[i][j] = Integer.parseInt(strTableS[i][j]);
            }
        }

        Integer[] answerArr = new Integer[N];
        answerArr[1] = ((tableS[0][1] - tableS[0][2]) + tableS[1][2])/2;
        answerArr[0] = tableS[0][1] - answerArr[1];
        for(int i=2; i<N; i++) {
            answerArr[i] = answerArr[i-1] + (tableS[0][i] - tableS[0][i-1]);
        }
        for(int i=0; i<N; i++) {
            System.out.print(answerArr[i] + " ");
        }
    }
}
