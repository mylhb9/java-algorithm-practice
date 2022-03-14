package part5;

import java.util.Scanner;

public class FlipString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArray = sc.nextLine().toCharArray();
        int medium = charArray.length / 2;
        for(int i=0; i<medium; i++) {
            char pivot = charArray[i];
            charArray[i] = charArray[charArray.length-1-i];
            charArray[charArray.length-1-i] = pivot;
        }
        for(int i=0; i<charArray.length; i++) {
            System.out.print(charArray[i]);
        }
    }
}
