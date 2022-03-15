package level1;

import java.util.Scanner;

public class CountOfDrainage {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int A = Integer.parseInt(strArr[0]);
        int B = Integer.parseInt(strArr[1]);
        int C = Integer.parseInt(strArr[2]);

        int count = 0;
        if(B>A) {
            for(int i=A; i<=B; i++) {
                if(i % C == 0) {
                    count++;
                }
            }
        } else {
            for(int i=B; i<=A; i++) {
                if(i % C == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
