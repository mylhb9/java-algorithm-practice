package part7;

import java.util.Scanner;

class MyQueue1 {
    private Integer[] queueArr;
    int quantity;
    int length = 0;
    int f = 0, r = 0;

    public MyQueue1(int quantity) {
        this.quantity = quantity;
        this.queueArr = new Integer[quantity];
    }

    public void push(int x) {
        if(length >= quantity) {
            System.out.println("Overflow");
        } else {
            queueArr[r] = x;
            r++;
            if(r >= quantity) {
                r=0;
            }
            length++;
        }
    }

    public int pop() {
        if(length <= 0) {
            System.out.println("Underflow");
        } else {
            queueArr[f] = 0;
            f++;
            if(f >= quantity) {
                f=0;
            }
            length--;
        }
        return 0;
    }

    public void front() {
        if(length <= 0) {
            System.out.println("NULL");
        } else {
            System.out.println(queueArr[f]);
        }
    }
}

public class ImplementCircularQueue1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);

        MyQueue1 queue = new MyQueue1(n);

        String[][] inputArr = new String[m][2];
        for(int i=0; i<m; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }

        for(int i=0; i<m; i++) {
            if(inputArr[i][0].equals("1")) {
                queue.push(Integer.parseInt(inputArr[i][1]));
            } else if(inputArr[i][0].equals("2")) {
                queue.pop();
            } else {
                queue.front();
            }
        }

    }
}
