package part5;

import java.util.Scanner;

public class StringZip1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArr = sc.nextLine().toCharArray();
        String[] outputArr = new String[1005];
        int count = 0;
        for(int i=1; i<charArr.length; i++) {
            count++;
            if(charArr[i-1] != charArr[i]) {
                if(count!=1) {
                    outputArr[i-1] = count + "" + charArr[i-1];
                } else {
                    outputArr[i-1] = "" + charArr[i-1];
                }
                count = 0;
            } else if(i==charArr.length-1 && charArr[i-1] == charArr[i]) {
                if(count!=1) {
                    outputArr[i-1] = (count+1) + "" + charArr[i-1];
                } else {
                    outputArr[i-1] = "2" + charArr[i-1];
                }
            }
            if(i==charArr.length-1 && charArr[i-1] != charArr[i]) {
                outputArr[i] = "" + charArr[i];
            }
        }
        for(int i=0; i<outputArr.length; i++) {
            if(outputArr[i] != null) {
                System.out.print(outputArr[i]);
            }
        }
    }
}
