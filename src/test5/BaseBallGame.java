package test5;

import java.util.*;

public class BaseBallGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] scores = new int[N];
        int[] strikes = new int[N];
        int[] balls = new int[N];

        for(int i=0; i<N; i++) {
            scores[i] = sc.nextInt();
            strikes[i] = sc.nextInt();
            balls[i] = sc.nextInt();
        }
        int count = 0;
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                for(int k=1; k<=9; k++) {
                    boolean check = false;
                    if(i != j && j != k && k != i) {
                        for(int p=0; p<N; p++) {
                            int strike = 0;
                            int ball = 0;
                            int first = scores[p] / 100;
                            int second = (scores[p] / 10) % 10;
                            int third = scores[p] % 10;

                            if(i==first) {
                                strike++;
                            }
                            if(j==second) {
                                strike++;
                            }
                            if(k==third) {
                                strike++;
                            }
                            if(i == second || i==third) {
                                ball++;
                            }
                            if(j == first || j == third) {
                                ball++;
                            }
                            if(k == first || k == second) {
                                ball++;
                            }

                            if(!(strikes[p] == strike && balls[p] == ball)) {
                                check = true;
                            }
                        }
                        if(!check) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
