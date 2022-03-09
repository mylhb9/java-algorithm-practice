package simpleBruteForce;

import java.util.Scanner;

public class ColorPaper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[][] strArray = new String[N][4];
        Integer[][] intArray = new Integer[N][4];
        for(int i=0; i<N; i++) {
            strArray[i] = sc.nextLine().split(" ");
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<4; j++) {
                intArray[i][j] = Integer.parseInt(strArray[i][j]);
            }
        }

        for(int i=0; i<N; i++) {

            if(i == N-1) {
                System.out.println(intArray[i][2] * intArray[i][3]);
            } else if(intArray[i+1][0] + intArray[i+1][2] > intArray[i][0] + intArray[i][2] && intArray[i+1][1] + intArray[i+1][3] > intArray[i][1] + intArray[i][3]){
                System.out.println(intArray[i][2] * intArray[i][3] - (intArray[i][0] + intArray[i][2] - intArray[i+1][0]) * (intArray[i][1] + intArray[i][3] - intArray[i+1][1]));
            } else if(intArray[i+1][0] + intArray[i+1][2] > intArray[i][0] + intArray[i][2] && intArray[i+1][1] + intArray[i+1][3] < intArray[i][1] + intArray[i][3]) {
                System.out.println(intArray[i][2] * intArray[i][3] - (intArray[i][0] + intArray[i][2] - intArray[i+1][0]) * (intArray[i+1][3]));
            } else if(intArray[i+1][0] + intArray[i+1][2] < intArray[i][0] + intArray[i][2] && intArray[i+1][1] + intArray[i+1][3] > intArray[i][1] + intArray[i][3]) {
                System.out.println(intArray[i][2] * intArray[i][3] - (intArray[i+1][2]) * (intArray[i][1] + intArray[i][3] - intArray[i+1][1]));
            } else {
                System.out.println(intArray[i][2] * intArray[i][3] - (intArray[i+1][2]) * (intArray[i+1][3]));
            }
        }


    }
}
