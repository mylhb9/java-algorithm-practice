package part9;

import java.util.Scanner;

// 문제: 2 X N 직사각형 모양의 칸이 있다. 이를 2 X 1 모양의 타일로 가득 채우려 한다.
// 가능한 경우의 수를 출력하는 프로그램을 만들자
// 출력시 1,000,007 로 나눈 나머지를 출력해라

// 입력: N 이 주어진다 (1<= N <= 100)
// 출력: 나머지를 출력해라

// 1. 부분문제를 정의한다. 2. 점화식을 만든다. 3. 문제를 해결한다.
// 오른쪽 블록을 기준으로 세워져 있는 경우와 누워져 있는 경우를 나누어 생각한다.
// 세워져 있는 경우 현재 i 번째 경우의 수에서 i-1 경우의 수라고 볼 수 있으며
// 누워져 있는 경우 i-2 경우의 수라고 볼 수 있다.
public class NumberOfCasesOfRectangularArrangement {
    Long[] remem;
    public long numcases(int x) {
        if(x == 1) {
            return 1;
        } else if(x == 2) {
            return 2;
        } else {
            if(remem[x] != null) {
                return remem[x];
            }
            remem[x] = numcases(x-1) + numcases(x-2);
            return remem[x] % 1000007;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        NumberOfCasesOfRectangularArrangement m = new NumberOfCasesOfRectangularArrangement();
        m.remem = new Long[10000];
        System.out.println(m.numcases(N));
    }
}
