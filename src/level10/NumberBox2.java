package level10;

import java.util.*;

public class NumberBox2 {
    boolean[] checks = new boolean[2000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] boxArr = new Integer[N];
        NumberBox2 m = new NumberBox2();
        for(int i=0; i<N; i++) {
            boxArr[i] = sc.nextInt();
            m.checks[boxArr[i] + 1000000] = true;
        }
        int M = sc.nextInt();
        Integer[] answerArr = new Integer[M];
        for(int i=0; i<M; i++) {
            answerArr[i] = sc.nextInt();
        }

        for(int i=0; i<M; i++) {
            if(m.checks[answerArr[i] + 1000000]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        sc.close();
    }
}
