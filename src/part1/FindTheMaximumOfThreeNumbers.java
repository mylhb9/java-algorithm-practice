package part1;

import java.util.Scanner;

public class FindTheMaximumOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(Math.max(Math.max(a, b), c));

        sc.close();
    }
}
