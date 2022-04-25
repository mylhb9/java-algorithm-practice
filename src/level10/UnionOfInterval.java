package level10;

// 문제: 구간은 [s, e] 로 나타내고, 숫자를 나열한 것임
// n개의 구간이 있고, 이 구간들의 숫자를 배열 S에 넣어 정렬을 한다
// s[i] 가 무엇인지 출력하는 프로그램을 작성

// 입력: 첫 번째 줄에 구간의 개수 n이 주어짐
// 두 번째 줄부터 각 구간을 나타내는 숫자 s, e 가 주어짐 (s, e: 1~10억)
// 마지막 줄 값을 알고 싶은 숫자의 위치 i (i: 1~10조)

import java.util.*;

// 출력: S[i] 를 출력한다.
public class UnionOfInterval {
    long n;
    long[][] arr;

    private long getCount(long x) {
        long count = 0;
        for(int i = 0; i< n; i++) {
            if(arr[i][1] < x) {
                count += (arr[i][1] - arr[i][0] + 1);
            } else if(arr[i][0] <= x && x <= arr[i][1]) {
                count += (x - arr[i][0]);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        /*
            구간은 총 n 개가 들어있음
            1 2 3
            2 3 4 5 6 7 8 9 10
            1 2 3 4 5 6 7 8
            1 1 2 2 2 3 3 3 4 4 5 5 6 6 7 7 8 8 9 10
            s                   m                  e
            들어오는 수가 몇 번째 라는 것을 알 수 있음
        */


        /*
            1 2 3 4
            3 4 5
            1 2 3 3 4 4 5
            0 1 2 3 4 5 6
            s     m     e
         */


        long[][] arr = new long[n][2];
        long length = 0;
        for(int i=0; i<n; i++) {
            arr[i][0] = sc.nextLong();
            arr[i][1] = sc.nextLong();
            length += (arr[i][1] - arr[i][0] + 1);
        }

        long input = sc.nextLong();
        UnionOfInterval m = new UnionOfInterval();
        m.n = n;
        m.arr = arr;
        long start = 0;
        long end = 1000000001;
        while(start + 1 < end) {
            long mid = (start + end) / 2;
            long midOrder = m.getCount(mid);
            if(midOrder <= input) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(start);
    }
}
