package level1;

import java.util.Scanner;

public class NToM {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);

        for(int i=N; i<=M; i++) {
            System.out.print(i + " ");
        }

    }
}
