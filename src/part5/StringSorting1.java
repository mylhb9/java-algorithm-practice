package part5;

import java.util.Arrays;
import java.util.Scanner;

public class StringSorting1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] inputArr = new String[n];
        for(int i=0; i<n; i++) {
            inputArr[i] = sc.nextLine();
        }

        Arrays.sort(inputArr);
        for(int i=0; i<n; i++) {
            System.out.println(inputArr[i]);
        }
    }
}
