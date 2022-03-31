package level6;

import java.util.Arrays;
import java.util.Scanner;

// 문제: n 개의 문자열이 주어질 때, 문자열을 사전순으로 빠른 순서대로 정렬하는 프로그램 작성
// 입력: 문자열의 개수 n이 주어짐. (1 <= n <= 100)
// n 개의 줄에 대해 정렬하고자 하는 문자열이 주어짐 (1 <= 문자열의 길이 <= 100)
public class SortString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] strArr = new String[n];
        for(int i=0; i<n; i++) {
            strArr[i] = sc.nextLine();
        }

        Arrays.sort(strArr);
        for(int i=0; i<strArr.length; i++) {
            System.out.println(strArr[i]);
        }
    }
}