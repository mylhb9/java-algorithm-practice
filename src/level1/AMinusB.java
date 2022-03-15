package level1;

import java.util.Scanner;

public class AMinusB {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int A = Integer.parseInt(strArr[0]);
        int B = Integer.parseInt(strArr[1]);

        if(A<B) {
            System.out.println(-1);
        } else {
            System.out.println(A-B);
        }

    }
}
