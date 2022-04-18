package level10;

import java.util.Scanner;

// 문제: f(x) = x*x + x = a 를 만족하는 x 의 정수부분을 구해라
public class QuadraticAnswerGuess {
    public static long fx(long x) {
        return x*x+x;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
// 입력: 첫 번째 줄에 숫자 a가 주어진다 (1 <= a <= )
        long a = sc.nextLong();
        long min = 0;
        long start = 0;
        long end = (long) Math.sqrt(1000000000000000000L);

        while(start <= end) {
            long mid = (start + end) / 2;
            long result = fx(mid);
            if(result == a) {
                min = mid;
                break;
            } else if(result > a) {
                end = mid-1;
            } else{
                start = mid+1;
                if(min < mid) {
                    min = mid;
                }
            }
        }
// 출력: f(x) = a 를 만족하는 음수를 제외한 정수 x의 정수부분을 출력
        System.out.println(min);
    }
}
