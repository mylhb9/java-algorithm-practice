package part5;

import java.util.Arrays;
import java.util.Scanner;

public class StringSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strArr = new String[n];
        for(int i=0; i<n; i++) {
            strArr[i] = sc.nextLine();
        }
        Arrays.sort(strArr);
        for(int i=0; i<n; i++) {
            System.out.println(strArr[i]);
        }
    }
}
