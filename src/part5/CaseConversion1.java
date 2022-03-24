package part5;

import java.util.Scanner;

public class CaseConversion1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArr = sc.nextLine().toCharArray();
        for(int i=0; i<charArr.length; i++) {
            if(charArr[i] >= 97 && charArr[i] <= 122) {
                charArr[i] -= 32;
            } else if(charArr[i] >= 65 && charArr[i] <= 90) {
                charArr[i] += 32;
            }
        }
        for(int i=0; i<charArr.length; i++) {
            System.out.print(charArr[i]);
        }
    }
}
