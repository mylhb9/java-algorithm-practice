package level5;

import java.util.Scanner;

public class Fibonacci {
    public static int fibonacci(int x) {
        if(x == 0) {
            return 0;
        } else if(x == 1) {
            return 1;
        } else if(x == 2) {
            return 1;
        } else if(x == 3) {
            return 2;
        } else if(x == 4) {
            return 3;
        } else if(x == 5) {
            return 5;
        } else if(x == 6) {
            return 8;
        } else if(x == 7) {
            return 13;
        } else if(x == 8) {
            return 21;
        } else if(x == 9) {
            return 34;
        } else if(x == 10) {
            return 55;
        } else if(x == 11) {
            return 89;
        } else if(x == 12) {
            return 144;
        } else if(x == 13) {
            return 233;
        } else if(x == 14) {
            return 377;
        } else if(x == 15) {
            return 610;
        }  else {
            return fibonacci(x-1) + fibonacci(x-2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fibonacci(sc.nextInt()));
    }
}
