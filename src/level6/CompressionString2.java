package level6;

import java.util.Scanner;

public class CompressionString2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split("");
        String[] inputArr = new String[strArr.length+1];

        for(int i=0; i<strArr.length; i++) {
            inputArr[i] = strArr[i];
        }
        inputArr[strArr.length] = "#";
        int count = 1;
        for(int i=1; i<inputArr.length; i++) {
            if(!inputArr[i-1].equals(inputArr[i])) {
                if(count != 1) {
                    System.out.print(count + inputArr[i-1]);
                    count = 1;
                } else {
                    System.out.print(inputArr[i-1]);
                }
            } else {
                count++;
            }
        }
    }
}
