package level10;

// 문제: 알랩이는 구구단표처럼 NN단표를 만들었음
// NN단표는 2차원 배열의 모양으로 곱셈 1단부터 N단까지의 값들을 적어놓은 형태
// A[i][j] = i * j  알랩이는 N단까지 나온 숫자들 중에서 K번째로 작은 수를 찾고 싶어함.
// 중복되는 여러 수들을 고려, N*N개의 모든 수들 중에서 K번째 수를 구하는 것이다

// 입력: 첫쨰 줄에 배열의 크기 N이 주어짐.
// N은 100,000보다 작거나 같은 자연수임. 둘째 줄에 K가 주어짐. K는 N*N보다 작거나 같은 자연수임

// 출력: K번째 원소를 출력한다.

import java.util.Scanner;

public class NNTable {
    long N;
    public long getOrder(long p) {
        long count = 0;
        for(int i=1; i<=N; i++) {
            if(p > i*N) {
                count += N;
            } else {
                if(p % i == 0) {
                    count += p / i - 1;
                } else {
                    count += p / i;
                }
            }
        }
        return count+1;
    }
    /*
       1 2 3
       2 4 6
       3 6 9
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long K = sc.nextLong();

        NNTable m = new NNTable();
        m.N = N;

        long start = 1;
        long end = 1000000000;
        while(start + 1 < end) {
            long mid = (start + end) / 2;
            long midOrder = m.getOrder(mid);
            if(midOrder <= K) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(start);

    }
}
