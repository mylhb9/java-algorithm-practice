package level7;

import java.util.Scanner;

public class Factorial {
    Integer[] notes;
    public int getFactorial(int x) {
        if(x == 1) {
            return 1;
        } else {
            if(notes[x] != null) {
                return notes[x];
            }
            notes[x] = x * getFactorial(x-1);
            return notes[x];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Factorial m = new Factorial();
        m.notes = new Integer[11];
        System.out.println(m.getFactorial(N));
    }
}
