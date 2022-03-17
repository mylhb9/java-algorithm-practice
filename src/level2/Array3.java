package level2;

import java.util.Scanner;

public class Array3 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        int sum = 1;
        int beta = 1;
        for(int i=0; i<N; i++) {
            int pivot = sum;
            int alpha = i;
            for(int j=0; j<N-i; j++) {
                sum += alpha;
                alpha++;
                System.out.print(sum + " ");
            }
            System.out.println();
            sum = pivot;
            sum += beta;
            beta++;
        }
    }
}
