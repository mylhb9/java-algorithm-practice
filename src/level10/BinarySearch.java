package level10;

import java.util.Scanner;

// 문제: n 개의 오름차순으로 정렬된 숫자가 주어지고, 그 후 q개의 질문이 주어진다.
// 각 질문은 특정 숫자가 n 개의 숫자 내에 존재하는지를 판별하는 것이다
// 모든 q개의 질문에 대하여 답을 하는 프로그램을 작성해라
public class BinarySearch {
    // start  mid  value    end
    public int binarySearch(Integer[] arr, int start, int end, int value) {
        // 이미 정렬된 배열에서 arr의 중간 index 에 해당하는 값을 찾고지하는 값과 비교
        // 값이 같은면 해당 index 를 출력하고, 값이 없으면 -1 리턴
        // 찾으려는 값이 기준 값보다 큰 경우, 작은 경우 해당 범위에서 다시 binarySearch
        int mid = (start + end) / 2;

        if(start > end) {
            return -1;
        } else if(start == end) {
            if(arr[start] == value) {
                return start;
            } else {
                return -1;
            }
        }

        if(arr[mid] == value) {
            return mid;
        } else {
            if(arr[mid] > value) {
                return binarySearch(arr, start, mid-1, value);
            } else {
                return binarySearch(arr, mid + 1, end, value);
            }
        }
    }

    public static void main(String[] args) {
// 입력: 숫자의 개수 n(1 <= n <= 100,000)과 질문의 개수 q(1 <= q <= 100,000)가 주어진다,
// 두 번째 줄에 n개의 숫자가 주어진다, 세 번째 줄에 q개의 질문이 주어진다.
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int q = Integer.parseInt(strArr[1]);

        String[] inputArr = sc.nextLine().split(" ");
        String[] findArr = sc.nextLine().split(" ");

        Integer[] toSortingArr = new Integer[n];
        for(int i=0; i<n; i++) {
            toSortingArr[i] = Integer.parseInt(inputArr[i]);
        }

        Integer[] toFindArr = new Integer[q];
        for(int i=0; i<q; i++) {
            toFindArr[i] = Integer.parseInt(findArr[i]);
        }

        BinarySearch m = new BinarySearch();

// 출력: 각 질문에 대하여 숫자가 존재하면 YES, 아니면 NO를 한 줄에 하나씩 출력한다.

        for(int i=0; i<q; i++) {
            if(m.binarySearch(toSortingArr, 0, n-1, toFindArr[i]) == -1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
