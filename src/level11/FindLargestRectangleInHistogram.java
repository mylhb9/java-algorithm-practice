package level11;

// 문제: 히스토그램에서 가장 큰 직사각형 찾기
// 히스토그램이 주어질 때, 가장 큰 직사각형의 너비를 출력하는 프로그램을 작성하라
// 2 1 4 5 1 3 3
// 가장 큰 직사각형 8

// 입력: 첫째 줄에 히스토그램을 이루는 직사각형의 개수 N이 주어진다 (1 <= N <= 100,000)
// 둘째 줄에는 각 직사각형의 높이가 주어짐. 높이는 10,000 보다 작은 양의 정수

// 출력: 최대 직사각형의 너비를 출력

import java.util.Scanner;
import java.util.Stack;

public class FindLargestRectangleInHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++) {
            stack.push(sc.nextInt());
        }
        int max = 0;
        int area = 0;
        int width = 1;
        while(!stack.empty()) {
            int temp = stack.pop();
            if(!stack.empty() && temp >= stack.peek()) {
                area = width * temp;
            } else if(!stack.empty() && temp < stack.peek()) {
                area = width * stack.peek();
            }
            if(max < area) {
                max = area;
            }
            width++;
        }

        System.out.println(max);
    }
}
