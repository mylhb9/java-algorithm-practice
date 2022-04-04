package part9;

import java.util.*;

// 문제: 숫자 N을 제곱수의 합으로 표현할 때, 사용해야하는 제곱수의 최소 개수를 출력하는 프로그램을 작성
// 입력: N 이 주어짐 (1 <= N <= 100000)
// 출력: 필요한 제곱수의 최소 개수를 출력한다.
public class SumOfSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력: 주어진 N 을 변수에 담는다.
        int N = sc.nextInt();

        // 처리:
        // 필요한 제곱 수의 최소 개수를 담아둔 배열 table[]을 만든다
        // 이전 값이 제곱수를 만드는데 필요한 최소 개수라면, 다음 값은 그 값에 1을 더한 값
        // 이것은 해당 수가 제곱수가 아닐 경우에 성립한다.
        Integer[] table = new Integer[100001];
        Arrays.fill(table, 200000);
        for(int i=1; i*i<=N; i++) {
            table[i*i] = 1;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j*j<=i; j++) {
                table[i] = Math.min(table[i], table[i - j*j]+1);
            }
        }
        System.out.println(table[N]);
    }
}


// 1 1      1
// 2 1+1    2
// 3 1+1+1  3
// 4 4      1
// 5 4+1    2
// 6 4+1+1  3
// 7 4+1+1+1  4
// 8 4+4    2
// 9 9      1
