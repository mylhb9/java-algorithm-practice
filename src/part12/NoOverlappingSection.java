package part12;

// 문제: n개의 숫자가 주어지고, r개의 연속된 숫자를 선택했을 때, 연속 부분 내에서는 중복되지 않기를 원한다.
// 선택된 숫자들 사이에서는 중복이 존재하지 않는다. r의 최댓값을 구하는 프로그램을 작성하세요

// 입력: 첫째 줄에는 숫자의 개수 n이 주어진다 (1 <= n <= 100,000)
// 둘째 줄에 n개의 숫자가 주어진다
// 각 숫자는 항상 1보다 크거나 같고, n보다 작거나 같다

// 출력: r의 최댓값을 출력한다.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoOverlappingSection {

    int[] arr;
    int n;

    public boolean continues(int interval) {
        List<Integer> memoryList = new ArrayList<>();
        int[] visited = new int[100001];
        for(int i=0; i<interval; i++) {
             visited[arr[i]] += 1;
             if(visited[arr[i]] > 1) {
                 memoryList.add(arr[i]);
             }
        }

        if(memoryList.size() == 0) {
            return true;
        }

        for(int i=0; i<n-interval; i++) {
            visited[arr[i]] -= 1;
            visited[arr[i+interval]] += 1;

            if(visited[arr[i]] <= 1) {
                memoryList.remove((Object) arr[i]);
            }
            if(visited[arr[i+interval]] > 1) {
                memoryList.add(arr[i+interval]);
            }

            if(memoryList.size() == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        NoOverlappingSection m = new NoOverlappingSection();
        m.n = n;
        m.arr = arr;

        int s = 1;
        int e = n+1;
        while(s + 1 < e) {
            int mid = (s+e) / 2;
            if(m.continues(mid)) {
                s = mid;
            } else {
                e = mid;
            }

        }
        System.out.println(s);
    }
}
