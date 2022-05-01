package level12;

// 문제: 큐 구현하기
// push X: 큐에 정수 X를 push 한다. rear 포인터가 더이상 뒤로 갈 수 없다면, "Overflow" 를 출력한다.
// pop: 큐에서 정수 하나를 pop 한다. 만약 front 포인터가 더이상 뒤로 갈 수 없다면, "Underflow" 를 출력한다.
// front: 큐의 front 에 있는 정수를 출력한다. 만약 큐가 비어있다면 "NULL" 을 출력한다.
// 크기가 n인 배열로 만든 큐에 m개의 연산을 하는 프로그램을 작성

// 입력: 첫째 줄에 큐를 만들 수 있는 배열의 크기 n, 연산의 개수 m 이 주어진다
// 두 번쨰 줄부터 연산이 주어진다.

// 출력: 연산의 결과를 출력한다.

import java.util.Scanner;
class MyQueue {
    int f = 0;
    int r = 0;
    int capacity;
    int[] arr = new int[100];

    void push(int x) {
        if(r>=capacity) {
            System.out.println("Overflow");
        } else {
            arr[r++] = x;
        }
    }

    void pop() {
        if(r-f <= 0) {
            System.out.println("Underflow");
        } else {
            arr[f++] = 0;
        }
    }
    // 3 4 5
    // 1 3 3
    void front() {
        if(r-f <=0) {
            System.out.println("NULL");
        } else {
            System.out.println(arr[f]);
        }
    }
}

public class ImplementsQueue {
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

        MyQueue queue = new MyQueue();
        queue.capacity = n;

        for(int i=0; i<m; i++) {
            if(arr[i][0] == 1) {
                queue.push(arr[i][1]);
            } else if(arr[i][0] == 2) {
                queue.pop();
            } else {
                queue.front();
            }
        }

    }
}
