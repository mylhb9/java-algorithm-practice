package level4;

import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        String[][] inputArr = new String[N][3];
        for (int i = 0; i < N; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }

        Integer[] point = new Integer[N];
        Integer[] strikes = new Integer[N];
        Integer[] balls = new Integer[N];
        for (int i = 0; i < N; i++) {
            point[i] = Integer.parseInt(inputArr[i][0]);
            strikes[i] = Integer.parseInt(inputArr[i][1]);
            balls[i] = Integer.parseInt(inputArr[i][2]);
        }

        int count = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i != j && j != k && k != i) {

                        boolean check = false;
                        for (int p = 0; p < N; p++) {
                            int strike = 0;
                            int ball = 0;
                            int first = point[p] / 100;
                            int second = (point[p] / 10) % 10;
                            int third = point[p] % 10;
                            if (i == first) {
                                strike++;
                            }
                            if (j == second) {
                                strike++;
                            }
                            if (k == third) {
                                strike++;
                            }
                            if (i == second || i == third) {
                                ball++;
                            }
                            if (j == first || j == third) {
                                ball++;
                            }
                            if (k == first || k == second) {
                                ball++;
                            }
                            if (!(strike == strikes[p] && ball == balls[p])) {
                                check = true;
                            }

                        }
                        if (!check) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
