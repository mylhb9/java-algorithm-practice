package level7;

import java.util.Scanner;

public class Factorial1 {
    Integer[] notes;
    public int factorial(int n) {
        if(n == 0) {
            return 1;
        } else {
            if(notes[n] != null) {
                return notes[n];
            }
            notes[n] = n * factorial(n-1);
            return notes[n];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Factorial1 m = new Factorial1();
        m.notes = new Integer[11];
        System.out.println(m.factorial(N));
    }
}
