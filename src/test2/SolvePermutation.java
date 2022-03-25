package test2;

import java.util.Arrays;
import java.util.Scanner;

public class SolvePermutation {
    int n;
    int r;
    boolean[] checkArr = new boolean[100];
    char[] charArr = new char[100];
    public void permutation(int x) {
        if(x >= r) {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<r; i++) {
                sb.append(charArr[i]);
            }
            System.out.println(sb);
            sb = new StringBuffer();
        } else {
            for(int i=0; i<n; i++) {
                if(!checkArr[i]) {
                    char pivot = (char) ('a' + i);
                    charArr[x] = pivot;
                    checkArr[i] = true;
                    permutation(x+1);
                    charArr[x] = 0;
                    checkArr[i] = false;
                }

            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int r = Integer.parseInt(strArr[1]);

        SolvePermutation m = new SolvePermutation();
        m.n = n;
        m.r = r;
        Arrays.fill(m.checkArr, false);
        m.permutation(0);;
    }
}
