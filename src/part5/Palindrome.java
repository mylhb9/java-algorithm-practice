package part5;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArr = sc.nextLine().toCharArray();
        char[] copiedCharArr = charArr.clone();

        int medium = copiedCharArr.length / 2;
        for(int i=0; i<medium; i++) {
            char pivot = copiedCharArr[i];
            copiedCharArr[i] = copiedCharArr[charArr.length-1-i];
            copiedCharArr[charArr.length-1-i] = pivot;
        }

        boolean check = false;
        for(int i=0; i<copiedCharArr.length; i++) {
            if(charArr[i] != copiedCharArr[i]) {
                check = true;
            }
        }
        if(!check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
