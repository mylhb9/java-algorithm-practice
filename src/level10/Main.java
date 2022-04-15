package level10;

import java.util.Scanner;

// 문제: f(x) = x*x + x = a 를 만족하는 x 의 정수부분을 구해라
public class Main {
    public void binarySearch(Integer[] arr, int start, int end, int value) {
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
// 입력: 첫 번째 줄에 숫자 a가 주어진다 (1 <= a <= )
        long a = Long.parseLong(sc.nextLine());
        a = (long) Math.sqrt(a);
        int sum = 1;
        int x = 1;
        while(a >= sum) {
            sum = x * (x+1);
            x++;
        }

// 출력: f(x) = a 를 만족하는 음수를 제외한 정수 x의 정수부분을 출력
        System.out.println(x-2);
    }
}
