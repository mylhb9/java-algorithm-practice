package part5;

import java.util.Scanner;

public class SpoilAssignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(input.replaceAll(" ", ""));
    }
}
