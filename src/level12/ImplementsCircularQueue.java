package level12;

// 문제: 원형큐 구현하기
// 원형큐는 선형큐의 문제를 해결한 큐이다
// push X : 큐에 정수 X를 push 한다. 만약 rear 포인터가 더이상 뒤로 갈 수 없다면, "Overflow"
// pop : 큐에서 정수 하나를 pop 한다. 만약 front 포인터가 더이상 뒤로 갈 수 없다면, "Underflow"
// front : 큐의 front 에 있는 정수를 출력한다. 큐가 비어있다면 "NULL" 출력

// 입력: 첫째 줄에 큐의 크기 n, 연산의 개수 m이 주어진다
// 두 번째 줄부터 연산이 주어진다.

// 출력: 연산의 결과를 출력한다.
import java.util.Scanner;

class MyQueue1 {
    int capacity;
    int[] arr;
    int f = 0;
    int r = 0;
    int length = 0;

    void push(int x) {
        if(length >= capacity) {
            System.out.println("Overflow");
        } else {
            arr[r++] = x;
            length++;
            if(r >= capacity) {
                r = 0;
            }
        }
    }

    void pop() {
        if(length <= 0) {
            System.out.println("Underflow");
        } else {
            arr[f++] = 0;
            length--;
            if(f >= capacity) {
                f = 0;
            }
        }
    }
    // 1 2 3
    // 1
    void front() {
        if(length <= 0) {
            System.out.println("NULL");
        } else {
            System.out.println(arr[f]);
        }
    }
}


public class ImplementsCircularQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[m][2];
        for(int i=0; i<m; i++) {
            arr[i][0] = sc.nextInt();
            if(arr[i][0] == 1) {
                arr[i][1] = sc.nextInt();
            }
        }

        MyQueue1 queue = new MyQueue1();
        queue.capacity = n;
        queue.arr = new int[n];
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
