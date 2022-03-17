package level2;

import java.util.Scanner;

public class Array2 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);

        String[][] str2DArr = new String[N][M];
        for(int i=0; i<N; i++) {
            str2DArr[i] = sc.nextLine().split(" ");
        }

        String[] AB = sc.nextLine().split(" ");
        int A = Integer.parseInt(AB[0]);
        int B = Integer.parseInt(AB[1]);

        System.out.println(str2DArr[A][B]);

    }
}
