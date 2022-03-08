package array;

import java.util.Scanner;

public class Array3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int num = 1;
        int k = 0;
        int m =0;
        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++) {
                num+=j;
                System.out.print(num+" ");
            }
            System.out.println();
            k++;
            m += k;
            num = m + 1;
        }
    }
}
