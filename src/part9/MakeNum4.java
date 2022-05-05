package part9;

import java.util.Scanner;

public class MakeNum4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] notes = new int[100001];
        notes[1] = 1;
        notes[2] = 2;
        notes[3] = 4;
        for(int i=4; i<=100000; i++) {
            notes[i] = (notes[i-1] + notes[i-2] + notes[i-3]) % 1000007;
        }
        System.out.println(notes[N]);
    }
}
