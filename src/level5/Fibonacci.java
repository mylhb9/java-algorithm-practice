package level5;

import java.util.Scanner;

public class Fibonacci {
    Integer[] notes;
    public int fibonacci(int x) {
        if(x == 0) {
            return 0;
        } else if(x == 1) {
            return 1;
        } else {
            if(notes[x] != null) {
                return notes[x];
            }
            notes[x] = fibonacci(x-1) + fibonacci(x-2);
            return notes[x];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fibonacci m = new Fibonacci();
        m.notes = new Integer[46];
        System.out.println(m.fibonacci(sc.nextInt()));
    }
}
