package part6;

import java.util.Scanner;

public class Factorial1 {
    public static int factorial(int N) {
        if(N == 1) {
            return 1;
        } else {
            return N * factorial(N-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = Integer.parseInt(sc.nextLine());
        System.out.println(factorial(input));
    }
}
