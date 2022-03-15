package level1;

import java.util.Scanner;

public class PlusMinus {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int A = Integer.parseInt(strArr[0]);
        int B = Integer.parseInt(strArr[1]);

        int sum = 0;
        for(int i=A; i<=B; i++) {
            if(i % 2 == 1) {
                sum += i;
            } else {
                sum -= i;
            }
        }

        System.out.println(sum);

    }
}
