package part12;


// 문제: 산성용액 - 1~10억 / 알칼리성 용액 - -1~-10억
// 같은 양의 두 용액을 혼합하여 특성값이 0 에 가장 가까운 용액을 만들려고 한다.

// 입력: 첫째 줄 전체 용액의 수 N (2 <= N < 100000)
// 둘째 줄에는 용액의 특성값을 나타내는 N개의 정수가 빈칸을 사이에 두고 주어짐
// N 개의 용액들의 특성값은 모두 다름
// 산성 용액 또는 알칼리성 용액만으로 입력이 주어지는 경우도 있음

import java.util.*;

// 출력: 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값을 출력한다.
// 0에 가장 가까운 용액을 만들어내는 경우가 두 개 이상일 경우에 특성값의 최솟값이 가장 작은 숫자를 출력
public class TwoSolutions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        Arrays.sort(arr);
        // -99 -2 1 4 98
        //            se
        int min = Integer.MAX_VALUE;
        int count = 0;
        int idx = 0;
        for(int i=0; i<N-1; i++) {
            int a = arr[i];
            int start = i+1;
            int end = N;
            while(start + 1 < end) {
                int mid = (start + end) / 2;
                if(Math.abs(a+arr[start])>=Math.abs(a+arr[mid])) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            aList.add(a);
            bList.add(arr[start]);
            if(min > Math.abs(a+arr[start])) {
                min = Math.abs(a+arr[start]);
                idx = count;
            }
            count++;

        }

        System.out.println(aList.get(idx) + " " + bList.get(idx));
    }
}
