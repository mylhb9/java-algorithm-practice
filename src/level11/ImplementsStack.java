package level11;

// 문제: 스택 구현하기
// -push: 스택에 정수 x 를 Push 한다. 스택이 다차서 push 할 수 없다면 Overflow 출력
// -pop: 스택에서 정수 하나를 Pop 한다. 스택이 비어서 pop 할 수 없다면 Underflow 출력
// -top: 스택의 top에 있는 정수를 출력한다. 스택이 비어있다면 NULL을 출력
// 크기가 n인 스택에 m개의 연산을 하는 프로그램을 작성
// Push 는 1, Pop은 2, Top은 3으로 표현한다.

// 입력: 첫째 줄에 스택의 크기 n, 연산의 개수 m이 주어진다

// 출력: 연산의 결과를 출력한다.

import java.util.Scanner;
class MyStack {
    int[] pocket = new int[100];
    int len = 0;
    int capacity;

    public void push(int x) {
        if(len >= capacity) {
            System.out.println("Overflow");
        } else {
            pocket[len++] = x;
        }
    }

    public void pop() {
        if(len <= 0) {
            System.out.println("Underflow");
        } else {
            pocket[len--] = 0;
        }
    }

    public void top() {
        if(len <= 0) {
            System.out.println("NULL");
        } else {
            System.out.println(pocket[len-1]);
        }
    }


}
public class ImplementsStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[m][2];
        for(int i=0; i<m; i++) {
            arr[i][0] = sc.nextInt();
            if(arr[i][0] == 1) {
                arr[i][1] = sc.nextInt();
            } else {
                arr[i][1] = 0;
            }
        }
        MyStack stack = new MyStack();
        stack.capacity = n;

        for(int i=0; i<m; i++) {
            if(arr[i][0] == 1) {
                stack.push(arr[i][1]);
            } else if(arr[i][0] == 2) {
                stack.pop();
            } else {
                stack.top();
            }
        }
    }
}
