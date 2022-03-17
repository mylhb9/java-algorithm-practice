package level2;

import java.util.Scanner;

public class Array1 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);
        Integer[][] intArr = new Integer[N][M];

        int a = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                intArr[i][j] = a;
                a++;
            }
        }


        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(intArr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
