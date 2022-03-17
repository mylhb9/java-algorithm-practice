package level2;

import java.util.Scanner;

public class NumPyramid {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int S = Integer.parseInt(strArr[1]);

        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1-i; j++) {
                System.out.print(" ");
            }
            for(int j=0; j<2*i+1; j++) {
                System.out.print(S);
                if(i % 2 == 0) {
                    S--;
                } else {
                    S++;
                }
                if(S>9) {
                    S%=9;
                }
                if(S<0) {
                    S+=10;
                }
                if(S==0) {
                    S=9;
                }
            }
            System.out.println();
            S += 2*(i+1);
            if(S>9) {
                S%=9;
            }
            if(S<0) {
                S+=10;
            }
            if(S==0) {
                S=9;
            }
        }

    }
}
