package part1;

import java.util.Scanner;

public class NToM22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int count = 0;
        for(int i=N; i<=M; i++) {
            count++;
            System.out.print(i+ " ");
            if(count % 8 == 0) {
                System.out.println();
            }
        }
        sc.close();
    }
}
