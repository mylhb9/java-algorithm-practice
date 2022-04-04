package part9;


import java.util.*;

// 문제: 숫자 N을 제곱수의 합으로 표현할 때, 사용해야하는 제곱수의 최소 개수를 출력하는 프로그램을 작성
// 입력: N 이 주어짐 (1<= N <= 100000)
// 출력: 필요한 제곱수의 최소 개수를 출력한다.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력: 주어진 N 을 변수에 담는다.
        int N = sc.nextInt();

        // 처리:
        // 제곱 수의 합으로 만들어서 으 최소의 개수를 구하는 로직
        // 최소 단위로
        for(int i=1; i*i<=N; i++) {

        }
    }
}
