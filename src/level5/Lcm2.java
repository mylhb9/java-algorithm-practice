package level5;

import java.util.Scanner;

// 유클리드 호제법을 이용한 풀이
public class Lcm2 {
    public static long getGcd(long a, long b) {
        long temp;
        while(a % b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        long A = Long.parseLong(strArr[0]);
        long B = Long.parseLong(strArr[1]);

        System.out.println(A / getGcd(A, B) * B);
    }
}
