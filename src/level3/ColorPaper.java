package level3;

import java.util.*;

public class ColorPaper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[][] inputArr = new String[N][4];
        Integer[][] answerArr = new Integer[101][101];

        for(int i=0; i<N; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }

        for(int i=0; i<101; i++) {
            for(int j=0; j<101; j++) {
                answerArr[i][j] = 0;
            }
        }

        for(int k=0; k<N; k++) {
            for(int i=Integer.parseInt(inputArr[k][1]); i<Integer.parseInt(inputArr[k][1]) + Integer.parseInt(inputArr[k][3]); i++) {
                for(int j=Integer.parseInt(inputArr[k][0]); j<Integer.parseInt(inputArr[k][0]) + Integer.parseInt(inputArr[k][2]); j++) {
                    answerArr[j][i] = k+1;
                }
            }
        }
        for(int k=0; k<N; k++) {
            int sum = 0;
            for(int i=0; i<101; i++) {
                for(int j=0; j<101; j++) {
                    if(answerArr[i][j] == k+1) {
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
