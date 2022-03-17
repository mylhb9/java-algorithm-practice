package level2;

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n-1-i; j++) {
                System.out.print(" ");
            }

            for(int j=0; j<1+2*i; j++) {
                System.out.print("*");
            }
            for(int j=0; j<n-1-i; j++) {
                System.out.print(" ");
            }
            for(int j=0; j<n-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
