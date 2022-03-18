package level3;

import java.util.*;

public class EightNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();
        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);

        String[][] inputArr = new String[N][M];

        for(int i=0; i<N; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N/2; j++) {
                String temp = inputArr[i][j];
                inputArr[i][j] = inputArr[i][N-1-j];
                inputArr[i][N-1-j] = temp;
            }
            for(int j=0; j<N; j++) {
                answer.append(inputArr[i][j]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}
