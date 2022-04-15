package level10;

import java.util.*;

// 문제: 숫자 박스에는 자연수들이 적혀있는 종이들이 N장 들어있다.
// 숫자 M개가 주어졌을 때, 이 숫자가 적혀있는 숫자가 상자 안에 있는지 아닌지를 구하는 프로그램 작성

// 입력: 숫자 정보의 개수 N (1 <= N <= 300,000)이 주어진다.
// 숫자 정보들이 주어진다. 절대값 1,000,000 이하의 정수이다.
// 두 숫자 카드에 같은 숫자가 적혀있는 경우는 없다.

// 셋째 줄에는 M (1 <= M <= 500,000)이 주어진다.
// 넷째 줄에는 윤성이가 숫자 박스에 있는지 아닌지를 구해야 할 M(1,000,000 이하의 정수)개의 숫자가 주어진다.

public class NumberBox1 {
    public int binarySearch(Integer[] arr, int start, int end, int value) {
        if(start > end) {
            return -1;
        } else if(start == end) {
            if(arr[start] == value) {
                return start;
            } else {
                return -1;
            }
        }

        int mid = (start + end) / 2;

        if(arr[mid] == value) {
            return mid;
        } else {
            if(arr[mid] > value) {
                return binarySearch(arr, start, mid-1, value);
            } else {
                return binarySearch(arr, mid+1, end, value);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NumberBox1 m = new NumberBox1();
        int N = sc.nextInt();
        Integer[] boxArr = new Integer[N];
        for(int i=0; i<N; i++) {
            boxArr[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        Integer[] answerArr = new Integer[M];
        for(int i=0; i<M; i++) {
            answerArr[i] = sc.nextInt();
        }

        Arrays.sort(boxArr);
        for(int i=0; i<M; i++) {
            if(m.binarySearch(boxArr, 0, N-1, answerArr[i]) == -1) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }

        sc.close();
    }
}