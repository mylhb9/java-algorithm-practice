package part1;

import java.util.Scanner;

public class FindMaxIn3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int a = Integer.parseInt(strArr[0]);
        int b = Integer.parseInt(strArr[1]);
        int c = Integer.parseInt(strArr[2]);

        int max = a;
        if(max < b) {
            max = b;
        }
        if(max < c) {
            max = c;
        }
        System.out.println(max);
    }
}
