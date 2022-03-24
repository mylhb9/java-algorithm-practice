package part5;

import java.util.Scanner;

public class Palindrome1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        StringBuffer adversedInput = new StringBuffer();
        char[] charArr = input.toCharArray();
        for(int i=charArr.length-1; i>=0; i--) {
            adversedInput.append(charArr[i]);
        }
        if(input.equals(String.valueOf(adversedInput))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
