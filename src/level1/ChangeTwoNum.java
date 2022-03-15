package level1;

import java.util.Scanner;

public class ChangeTwoNum {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");

        System.out.println(strArr[1] + " " + strArr[0]);

    }
}
