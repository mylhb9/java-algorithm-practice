package level1;

import java.util.Scanner;

public class YutPlay {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] yut = new String[]{"D", "C", "B", "A", "E"};

        String[][] strArr = new String[3][4];
        for(int i=0; i<3; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }

        Integer[][] intArr = new Integer[3][4];
        for(int i=0; i<3; i++) {
            for(int j=0; j<4; j++) {
                intArr[i][j] = Integer.parseInt(strArr[i][j]);
            }
        }

        int a = 0;
        int b = 0;
        int c = 0;

        for(int i=0; i<4; i++) {
            a += intArr[0][i];
            b += intArr[1][i];
            c += intArr[2][i];
        }
        System.out.println(yut[a]);
        System.out.println(yut[b]);
        System.out.println(yut[c]);

    }
}
