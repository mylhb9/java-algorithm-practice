package part6;

import java.util.Scanner;

public class Factorial2 {
    Integer[] notes;
    public int factorial(int x) {
        if(x == 0) {
            return 1;
        } else {
            if(notes[x] != null) {
                return notes[x];
            }
            notes[x] = x * factorial(x-1);
            return notes[x];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Factorial2 m = new Factorial2();
        m.notes = new Integer[N+1];
        System.out.println(m.factorial(N));
    }
}
