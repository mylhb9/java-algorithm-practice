package part5;

import java.util.Scanner;
public class CaseConversion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] strArr = sc.nextLine().toCharArray();

        for(int i=0; i<strArr.length; i++) {
            if(strArr[i] >= 97 && strArr[i] <= 122) {
                strArr[i] -= 32;
            } else if(strArr[i] >= 65 && strArr[i] <= 90) {
                strArr[i] += 32;
            }
        }
        for(int i=0; i<strArr.length; i++) {
            System.out.print(strArr[i]);
        }
    }
}