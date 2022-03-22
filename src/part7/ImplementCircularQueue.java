package part7;

import java.util.Scanner;

class Queue {
    int capacity;
    int f = 0;
    int r = 0;
    int length = 0;
    Integer[] intArr;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.intArr = new Integer[capacity];
    }

    void push(int x) {
        if(length >= capacity) {
            System.out.println("Overflow");
        } else {
            intArr[r] = x;
            r++;
            if(r >= capacity) {
                r = 0;
            }
            length++;
        }
    }

    void pop() {
        if(length <= 0) {
            System.out.println("Underflow");
        } else {
            intArr[f] = 0;
            f++;
            if(f >= capacity) {
                f = 0;
            }
            length--;
        }
    }

    void front() {
        if(length <=0) {
            System.out.println("NULL");
        } else {
            System.out.println(intArr[f]);
        }
    }

}
public class ImplementCircularQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);

        Queue queue = new Queue(n);

        String[][] inputArr = new String[m][2];

        for(int i=0; i<m; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }

        for(int i=0; i<m; i++) {
            if(inputArr[i][0].equals("1")) {
                queue.push(Integer.parseInt(inputArr[i][1]));
            } else if(inputArr[i][0].equals("2")) {
                queue.pop();
            } else if(inputArr[i][0].equals("3")) {
                queue.front();
            }
        }
    }
}
