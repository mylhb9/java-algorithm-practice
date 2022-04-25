package level10;

// 문제: 산성 용액과 알칼리성 용액을 보유하고 있다
// 각 용액에는 그 용액의 특성을 나타내는 하나의 정수가 주어져있다
// 산성용액: 1~ 1,000,000,000 까지의 양의 정수로 나타내고
// 알칼리성용액 : -1 ~ -1,000,000,000 까지의 음의 정수로 나타낸다.
// 같은 양의 두 용액을 혼합한 용액의 특성값이 0에 가장 가까운 용액을 만들려고 한다.
// 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램을 작성

// 입력: 첫째 줄에는 전체 용액의 수 N (2 <= N <= 100,000)이 입력됨
// 둘째 줄에는 용액의 특성값을 나타내는 N개의 정수가 빈칸을 사에이 두고 주어진다.
// 이 수들은 모두 -1,000,000,000 이상 1,000,000,000 이하이다. 수는 모두 다르다

// 출력: 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값을 출력한다.
// 두 용액은 오름차순으로 출력한다. 0에 가장 가까운 용액을 만들어 내는 경우의 수가 2개 이상인 경우에는
// 특성값의 최솟값이 가장 작은 숫자를 출력한다.

import java.util.Arrays;
import java.util.Scanner;

public class TwoSolutions {
    int N, left, right;
    int[] arr;
    int result = 1000000001;
    public void getNum(int x) {
        int start = 0;
        int end = N;

        while(start+1<end) {
            int mid = (start + end) / 2;
            int cal = x + arr[mid];

            if(cal < 0) {
                cal = Math.abs(cal);
            }
            if(result > cal && x != arr[mid]) {
                result = cal;
                left = x;
                right = arr[mid];
            }

            if(cal == 0) {
                return;
            } else if(x+arr[mid] < 0) {
                start = mid;
            } else if(x+arr[mid] > 0) {
                end = mid;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        TwoSolutions m = new TwoSolutions();
        m.arr = arr;
        m.N = N;
        for(int i=0; i<N; i++) {
            m.getNum(arr[i]);
        }
        System.out.println(m.left+ " " + m.right);

    }
}