package level5;

import java.util.Scanner;

// 문제: nCm 의 끝자리 0의 개수를 출력하는 프로그램을 만들어라
// n! 은 소인수 몇개로 구성되어 있는지 알 수 있다.
// 따라서 10의 소인수들의 개수로 n! 에 0의 개수가 몇개인지 추론이 가능하고 그에 따른 계산이 가능하다
public class CombinationZero {
    public static int getNumOfDigits(int n, int x) {
        int answer = 0;
        int temp = x;
        while(temp <= n) {
            answer += n / temp;
            temp *= x;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);

        System.out.println(Math.min(getNumOfDigits(n, 2) - getNumOfDigits(m, 2) - getNumOfDigits(n-m, 2), getNumOfDigits(n, 5) - getNumOfDigits(m, 5) - getNumOfDigits(n-m, 5)));
    }
}
