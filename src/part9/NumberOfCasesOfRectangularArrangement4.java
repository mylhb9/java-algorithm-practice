package part9;

import java.util.Scanner;

public class NumberOfCasesOfRectangularArrangement4 {
    int[] notes = new int[101];
    public int getFactorial(int N) {
        if(N==1) {
            return 1;
        } else if(N==2) {
            return 2;
        } else {
            if(notes[N] == 0) {
                notes[N] = (getFactorial(N-1) % 1000007 + getFactorial(N-2) % 1000007) % 1000007;
            }
            return notes[N];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        NumberOfCasesOfRectangularArrangement4 m = new NumberOfCasesOfRectangularArrangement4();
        System.out.println(m.getFactorial(N));
    }
}
