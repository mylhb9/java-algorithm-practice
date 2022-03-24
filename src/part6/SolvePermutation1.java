package part6;

import java.util.Arrays;
import java.util.Scanner;

public class SolvePermutation1 {
    int n, r;
    char[] charArr = new char[10];
    boolean[] checkArr = new boolean[10];

    public void permutation(int x) {
        if(x >= r) {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<r; i++) {
                sb.append(charArr[i]);
            }
            System.out.println(sb);
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
        String[] inputArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int r = Integer.parseInt(inputArr[1]);
        SolvePermutation1 m = new SolvePermutation1();

        m.n = n;
        m.r = r;
        Arrays.fill(m.checkArr, false);
        m.permutation(0);
    }
}
