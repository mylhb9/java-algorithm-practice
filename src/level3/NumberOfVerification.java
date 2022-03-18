package level3;

import java.util.Scanner;
public class NumberOfVerification {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        Integer[] intArr = new Integer[5];
        for(int i=0; i<5; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        int sum = 0;
        for(int i=0; i<5; i++) {
            sum += intArr[i] * intArr[i];
        }
        System.out.println(sum % 10);

    }
}