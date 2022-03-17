package level2;

import java.util.Scanner;

public class Dicegame {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        String[][] strArr = new String[N][3];
        for(int i=0; i<N; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }

        Integer[][] intArr = new Integer[N][3];
        for(int i=0; i<N; i++) {
            for(int j=0; j<3; j++) {
                intArr[i][j] = Integer.parseInt(strArr[i][j]);
            }
        }

        Integer[] priceArr = new Integer[N];
        for(int i=0; i<N; i++) {
            if(intArr[i][0] == intArr[i][1] && intArr[i][1] == intArr[i][2]) {
                priceArr[i] = 10000 + intArr[i][0] * 1000;
            } else if(intArr[i][0] == intArr[i][1]) {
                priceArr[i] = 1000 + intArr[i][1] * 100;
            } else if(intArr[i][0] == intArr[i][2]) {
                priceArr[i] = 1000 + intArr[i][0] * 100;
            } else if(intArr[i][1] == intArr[i][2]) {
                priceArr[i] = 1000 + intArr[i][1] * 100;
            } else {
                int max = 0;
                if(max < intArr[i][0]) {
                    max = intArr[i][0];
                }
                if(max < intArr[i][1]) {
                    max = intArr[i][1];
                }
                if(max < intArr[i][2]) {
                    max = intArr[i][2];
                }
                priceArr[i] = max * 100;
            }
        }
        int max = 0;
        for(int i=0; i<N; i++) {
            if(max < priceArr[i]) {
                max = priceArr[i];
            }
        }
        System.out.println(max);

    }
}
