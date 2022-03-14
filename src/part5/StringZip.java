package part5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringZip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArr = sc.nextLine().toCharArray();
        int count = 1;
        List<String> strList = new ArrayList<>();
        for(int i=0; i<charArr.length-1; i++) {
            if(charArr[i] == charArr[i+1]) {
                count++;
                if(i==charArr.length-2) {
                    strList.add(count+String.valueOf(charArr[i]));
                }
            }
            else {
                if(count == 1) {
                    strList.add(String.valueOf(charArr[i]));
                } else {
                    strList.add(count+String.valueOf(charArr[i]));
                }
                if(i==charArr.length-2) {
                    strList.add(String.valueOf(charArr[i+1]));
                }
                count = 1;
            }
        }

        for(int i=0; i<strList.size(); i++) {
            System.out.print(strList.get(i));
        }

    }
}
