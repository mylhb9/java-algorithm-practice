package part2;

import java.util.Scanner;

public class Triangle1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            for(int j=n-1-i; j<n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
