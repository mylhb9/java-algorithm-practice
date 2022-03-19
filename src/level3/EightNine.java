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

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(inputArr[i][M-1-j] + " ");
            }
            System.out.println();
        }
    }
}
