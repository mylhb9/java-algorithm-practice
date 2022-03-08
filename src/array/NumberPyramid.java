package array;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] stringArray = line.split(" ");

        int N = Integer.parseInt(stringArray[0]);
        int S = Integer.parseInt(stringArray[1]);

        for(int i=0; i<N; i++) {
            for(int j=i; j<N-1; j++) {
                System.out.print(" ");
            }

            for(int j=0; j<2*(i+1)-1; j++) {
                System.out.print(S);
                if(i % 2 == 0) {
                    S--;
                    if(S==0) {
                        S=9;
                    }
                } else {
                    S++;
                }
                if(S>9) {
                    S%=9;
                }
                if(S < 0) {
                    S = S % 10 + 10;
                }
            }
            System.out.println();
            S = S + 2*(i+1);
            if(S>9) {
                S%=9;
            }
            if(S < 0) {
                 S = S % 10 + 10;
            }
        }

    }
}
