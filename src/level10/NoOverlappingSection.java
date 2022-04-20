package level10;

import java.util.*;

// 문제: n개의 숫자가 주어지고, 이 중에서 r개의 연속된 숫자를 선택했을 때, 연속부분 내에서 숫자가 중복되지 않기를 원함
// 입력: 첫째 줄에는 숫자의 개수 n이 주어짐. 둘째 줄에는 n개의 숫자가 주어짐
// 출력: r의 최댓값을 출력한다.
public class NoOverlappingSection {
    int[] arr;
    public boolean check(int x) {
        List<Integer> memoryList = new ArrayList<>();
        int[] visitedCount = new int[100001];

        for(int i=0; i<x; i++) {
            visitedCount[arr[i]] += 1;
            if(visitedCount[arr[i]] > 1) {
                memoryList.add(arr[i]);
            }
        }
        if(memoryList.size() == 0) {
            return true;
        }


        for(int i=0; i<arr.length-x; i++) {
            visitedCount[arr[i+x]] += 1;
            visitedCount[arr[i]] -= 1;
            if(visitedCount[arr[i+x]] > 1) {
                memoryList.add(arr[i+x]);
            }
            if(visitedCount[arr[i]] <=1) {
                memoryList.remove((Object)arr[i]);
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
        m.arr = arr;


        int start = 1;
        int end = n+1;
        while(start+1 < end) {
            int mid = (start + end) / 2;
            if(m.check(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }
}
