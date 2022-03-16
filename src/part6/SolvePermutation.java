package part6;

import java.util.Arrays;
import java.util.Scanner;

public class SolvePermutation {
    int N;
    int R;
    char[] result = new char[50];
    boolean[] checkArr = new boolean[50];


    public void getResult(int x) {
        if(x >= R) {
            for(int i=0; i<result.length; i++) {
                if(result[i] != 0) {
                    System.out.print(result[i] + " ");
                }
            }
            System.out.println();
        } else {
            for(int i=0; i<N; i++) {
                char alpha = (char) (i + 'a');
                if(!checkArr[i]) {
                    result[x] = alpha;
                    checkArr[i] = true;
                    getResult(x+1);
                    result[x] = 0;
                    checkArr[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int R = Integer.parseInt(strArr[1]);
        SolvePermutation sp = new SolvePermutation();
        sp.N = N;
        sp.R = R;
        Arrays.fill(sp.checkArr, false);
        sp.getResult(0);

    }
}
