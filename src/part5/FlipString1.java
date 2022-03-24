package part5;

import java.util.Scanner;

public class FlipString1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArr = sc.nextLine().toCharArray();
        for(int i=charArr.length-1; i>=0; i--) {
            System.out.print(charArr[i]);
        }
    }
}
