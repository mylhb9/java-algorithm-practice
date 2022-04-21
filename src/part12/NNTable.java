package part12;

// 문제: 알랩이는 구구단표처럼 NN단표를 만들었다고 한다.
// 2차원 배열의 모양으로 곱셈 1단부터 N단까지의 값들을 적어놓은 형태
// N단까지 나온 숫자들 중에서 K번째로 작은수를 찾고 싶어함
// N*N 개의 모든 수들 중에서 K번쨰 수를 구하는 것

// 입력: 첫째 줄에 배열의 크기 N이 주어짐
// N은 100,000 보다 작거나 같은 자연수임
// 둘째 줄에 K가 주어짐. K는 N*N 보다 작거나 같은 자연수이다.

// 출력 K번째 원소를 출력한다.

// 3*3

// 1 2 3
// 2 4 6
// 3 6 9

import java.util.Scanner;

public class NNTable {
    long N;
    public long getOrder(long x) {
        long count = 0;
        for(int i=0; i<N; i++) {
            if(N * (i+1) < x) {
                count += N;
            } else {
                if(x % (i+1) == 0) {
                    count += (x / (i+1) - 1);
                } else {
                    count += (x / (i+1));
                }
            }
        }
        return count+1;
    }
    // 1 2 2 3 3 4 6 6 9
    // 1 2 3 4 5 6 7 8 9
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long K = sc.nextLong();

        NNTable m = new NNTable();
        m.N = N;

        // s: k번째 순서보다 낮은
        // e: k번쨰 순서보다 높은
        long s = 1;
        long e = N*N+1;
        while(s + 1 < e) {
            long mid = (s + e) / 2;
            long midOrder = m.getOrder(mid);
            if(midOrder <= K) {
                s = mid;
            } else {
                e = mid;
            }
        }
        System.out.println(s);
    }
}
