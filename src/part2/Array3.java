package part2;

import java.util.Scanner;

public class Array3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        int beta = 1;
        int sum = 1;
        int delta;
        for(int i=0; i<N; i++) {
            int alpha = i+1;
            delta = sum;
            for(int j=0; j<N-i; j++) {
                System.out.print(sum+" ");
                sum += alpha;
                alpha++;
            }
            System.out.println();
            beta++;
            sum = delta + beta;
        }
    }
}
