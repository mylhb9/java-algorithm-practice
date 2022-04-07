package part9;

import java.util.Scanner;

public class MakeNum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        Integer[] notes = new Integer[N+1];
        notes[1] = 1;
        notes[2] = 2;
        notes[3] = 4;

        for(int i=1; i<=N-3; i++) {
            notes[i+3] = (notes[i+2] % 1000007 + notes[i+1] % 1000007 + notes[i] % 1000007) % 1000007;
        }
        System.out.println(notes[N]);

    }
}
// 1 : 1   / 1
// 2 : 1+1  2 / 2
// 3 : 1+1+1  2+1  1+2  3 / 4
// 4 : 1+1+1+1  2+1+1  1+2+1  3+1  1+1+2  2+2  / 7
// 5 : 1+1+1+1+1
