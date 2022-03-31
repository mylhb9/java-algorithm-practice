package level5;

import java.util.Scanner;

public class CombinationPascal {
    public static int factorial(int x) {
        if(x == 1) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);

        int parent = 1;
        for(int i=n; i>n-m; i--) {
            parent *= i;
        }
        int son = factorial(m);
        System.out.println(parent/son);
    }
}
