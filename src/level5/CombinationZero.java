package level5;

import java.util.Scanner;

public class CombinationZero {
    Integer[] notes;
    public int factorial(int x) {
        if(x == 1) {
            return 1;
        } else {
            if(notes[x] != null) {
                return notes[x];
            }
            notes[x] = x * factorial(x - 1);
            return notes[x];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);

        CombinationZero c = new CombinationZero();
        c.notes = new Integer[1000010];
        long parent = 1;
        for(int i=n; i>n-m; i--) {
            parent *= i;
        }
        int son = c.factorial(m);
        System.out.println(son);
        long answer  = parent / son;

        int count = 0;
        while(true) {
            if(answer % 10 == 0) {
                answer /= 10;
                count++;
            } else {
                break;
            }

        }
        System.out.println(count);
    }
}
