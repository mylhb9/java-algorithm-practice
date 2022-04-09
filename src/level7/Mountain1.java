package level7;

import java.util.Scanner;

public class Mountain1 {
    public static String makeMountain(int x) {
        if(x == 1) {
            return "1";
        } else {
            return makeMountain(x-1) + x + makeMountain(x-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(makeMountain(n));
    }
}
