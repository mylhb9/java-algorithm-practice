package part9;

import java.util.Scanner;

public class NumberOfCasesOfRectangularArrangement4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] notes = new int[101];
        notes[1] = 1;
        notes[2] = 2;
        for(int i=3; i<=N; i++) {
            notes[i] = (notes[i-1] + notes[i-2]) % 1000007;
        }
        System.out.println(notes[N]);
    }
}
