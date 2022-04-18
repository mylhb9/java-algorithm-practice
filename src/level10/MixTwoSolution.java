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

public class MixTwoSolution {

    public int binarySearch(int[] arr, int start, int end, int value) {
        int mid = (start + end) / 2;
        int pivot = arr[mid] + value;
        while (true) {
            if (pivot > 0) {
                mid = mid - 1;
                pivot = arr[mid] + value;
            } else {
                mid = mid + 1;
                pivot = arr[mid] + value;
            }

            if (mid == start || mid == end) {
                break;
            }

            if (arr[mid] + value < 0 && arr[mid + 1] + value > 0) {
                break;
            }
            if (arr[mid] + value > 0 && arr[mid + 1] + value < 0) {
                break;
            }
        }

        return pivot;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);


        List<Integer> minusList = new ArrayList<>();
        List<Integer> plusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (arr[i] > 0) {
                plusList.add(arr[i]);
            } else {
                minusList.add(arr[i]);
            }
        }

        int idxMax = minusList.size() - 1;

        // 두개가 섞였을 때, 특성 값이 제일 작은 경우
        // 하나의 지정값과 다른 지정값의 차이가 거의 없는 수를 골라서 그중 최솟값이 가장 작은 수를 골라내야함
        // 마이너스 값을 기준으로 이진탐색을 돌리면 최솟값을 바꿔줄 필요가 없다

        int min = Integer.MAX_VALUE;
        int idxM = Integer.MAX_VALUE;
        int answer = 0;
        MixTwoSolution m = new MixTwoSolution();
        for (int i = 0; i <= idxMax; i++) {
            if (min > m.binarySearch(arr, 0, N - 1, minusList.get(i))) {
                if (idxM > minusList.get(i)) {
                    idxM = minusList.get(i);
                    answer = m.binarySearch(arr, 0, N - 1, minusList.get(i));
                }

            }
        }

        System.out.println(idxM + " " + (answer - idxM));
    }
}