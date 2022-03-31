package level5;

import java.util.Scanner;

public class PFactorization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int factor = 2;
        while(N!=1) {
            if(N % factor == 0) {
                System.out.println(factor);
                N = N / factor;
            } else {
                factor++;
            }
        }
    }
}
