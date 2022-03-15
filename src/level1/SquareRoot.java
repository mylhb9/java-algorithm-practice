package level1;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i=1; i<=N; i++) {
            if(i*i >= N) {
                System.out.println(i);
                break;
            }
        }

    }
}
