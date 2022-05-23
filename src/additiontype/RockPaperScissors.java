package additiontype;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        int[] S = new int[N+1];
        int[] R = new int[N+1];
        int[] P = new int[N+1];

        for(int i=0; i<N; i++) {
            String a = sc.nextLine();
            if(a.equals("S")) {
                S[i+1] = S[i];
                R[i+1] = R[i] + 1;
                P[i+1] = P[i];
            } else if (a.equals("P")) {
                S[i+1] = S[i] + 1;
                R[i+1] = R[i];
                P[i+1] = P[i];
            } else {
                S[i+1] = S[i];
                R[i+1] = R[i];
                P[i+1] = P[i] + 1;
            }

        }

        int max1 = -987987987;
        int max2 = -987987987;
        int max3 = -987987987;
        int max4 = -987987987;
        int max5 = -987987987;
        int max6 = -987987987;

        for(int i=1; i<=N; i++) {
            max1 = Math.max(max1, R[i]+S[N]-S[i]);
            max2 = Math.max(max2, S[i]+R[N]-R[i]);
            max3 = Math.max(max3, P[i]+S[N]-S[i]);
            max4 = Math.max(max4, S[i]+P[N]-P[i]);
            max5 = Math.max(max5, R[i]+P[N]-P[i]);
            max6 = Math.max(max6, P[i]+R[N]-R[i]);
        }


        System.out.println(Math.max(max1, Math.max(max2, Math.max(max3, Math.max(max4, Math.max(max5, max6))))));

        // R R R R R : 3
        // 1 2 2 3 3       R[i] + S[N] - S[i]
        // S S S S S : 1
        // 0 0 1 1 1
        // P P P P P : 1
        // 0 0 0 0 1
        //////////////////////
        // S S P S R



        sc.close();
    }
}
