package part4;

import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        String[][] strArray = new String[N][3];
        for(int i=0; i<N; i++) {
            strArray[i] = sc.nextLine().split(" ");
        }
        Integer[] points = new Integer[N];
        Integer[] strikes = new Integer[N];
        Integer[] balls = new Integer[N];
        for(int i=0; i<N; i++) {
            points[i] = Integer.parseInt(strArray[i][0]);
            strikes[i] = Integer.parseInt(strArray[i][1]);
            balls[i] = Integer.parseInt(strArray[i][2]);
        }

        int count = 0;
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                for(int k=1; k<=9; k++) {
                    boolean check = true;
                    if(i != j && j != k && k != i) {
                        for(int p=0; p<N; p++) {
                            int strike = 0;
                            int ball = 0;
                            int first = points[p] / 100;
                            int second = (points[p] / 10) % 10;
                            int third = points[p] % 10;

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
                                check = false;
                            }

                        }
                        if(check) {
                            count++;
                        }

                    }


                }
            }
        }
        System.out.println(count);
    }
}
