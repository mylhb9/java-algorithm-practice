package array;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] stringArray = line.split(" ");


        // 줄 수
        int N = Integer.parseInt(stringArray[0]);
        // 시작 숫자
        int S = Integer.parseInt(stringArray[1]);


        // 행을 바꾸는 for 문
        for(int i=0; i<N; i++) {
            // 빈칸을 만드는 for 문
            for(int j=i; j<N-1; j++) {
                System.out.print(" ");
            }
            // 숫자를 만드는 for 문
            for(int j=0; j<2*(i+1)-1; j++) {
                System.out.print(S);
                if(i % 2== 0) {
                    S--;
                } else {
                    S++;
                }
                if(S>9) {
                    S%=9;
                }
                if(S==0) {
                    S=9;
                }
                if(S < 0) {
                    S = S % 10 + 10;
                }
            }
            // 줄바꿈
            System.out.println();

            S = S + 2*(i+1);

            if(S>9) {
                S%=9;

            }
            if(S==0) {
                S=9;
            }
            if(S < 0) {
                 S = S % 10 + 10;
            }

        }


    }
}
