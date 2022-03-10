package simpleBruteForce;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[][] strings = new String[N][3];
        Integer[] points = new Integer[N];
        Integer[] strikes = new Integer[N];
        Integer[] balls = new Integer[N];
        Set<Integer> selectedNum = new HashSet<>();

        for(int i=0; i<N; i++) {
            strings[i] = sc.nextLine().split(" ");
            points[i] = Integer.parseInt(strings[i][0]);
            strikes[i] = Integer.parseInt(strings[i][1]);
            balls[i] = Integer.parseInt(strings[i][2]);
        }
        int count = 0;
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                for(int k=1; k<=9; k++) {
                    if(i != j && j != k && i != k) {
                        boolean flag = false;
                        for(int p=0; p<N; p++) {
                            int first = points[p] / 100;
                            int second = (points[p] / 10) % 10;
                            int third = points[p] % 10;

                            int strike = 0, ball = 0;
                            if(first == i) {
                                strike++;
                            }
                            if(second == j) {
                                strike++;
                            }
                            if(third == k) {
                                strike++;
                            }
                            if(first == j || first == k) {
                                ball++;
                            }
                            if(second == i || second == k) {
                                ball++;
                            }
                            if(third == i || third == j) {
                                ball++;
                            }

                            if(!(strikes[p] == strike && balls[p] == ball)) {
                                flag = true;
                            }
                        }
                        if(!flag) {
                            count++;
                        }
                    }
                }
            }
        }


        System.out.println(count);
    }
}
