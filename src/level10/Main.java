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

import java.util.*;

public class Main {
    Map<Integer, Integer> myMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 음수에서 양수로 바뀌는 값을 기준으로 잡는다
        Arrays.sort(arr);
        // -99 -2 1 4 98
        //  1   2 3 4 5
        Main m = new Main();
        for(int i=0; i<N; i++) {
            int a = arr[i];
            int start = i+1;
            int end = N;
            while(start+1 < end) {
                int mid = (start + end) / 2;
                if(a + arr[mid] < 0) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

            m.myMap.put(a, start-1);
        }

        System.out.println(m.myMap);
    }
}