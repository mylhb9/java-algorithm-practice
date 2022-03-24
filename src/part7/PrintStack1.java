package part7;

import java.util.Scanner;

class MyStack1 {
    private Integer[] stackArr;
    int length = 0;
    int capacity;

    public MyStack1(int n) {
        this.capacity = n;
        this.stackArr = new Integer[n];
    }

    public void push(int x) {
        if(length >= capacity) {
            System.out.println("Overflow");
        } else {
            stackArr[length] = x;
            length++;
        }
    }

    public void pop() {
        if(length <= 0) {
            System.out.println("Underflow");
        } else {
            stackArr[length-1] = 0;
            length--;
        }
    }
    public void top() {
        if(length <= 0) {
            System.out.println("NULL");
        } else {
            System.out.println(stackArr[length-1]);
        }
    }
}


public class PrintStack1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        MyStack1 stack = new MyStack1(n);

        String[][] inputArr = new String[m][2];

        for(int i=0; i<m; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }
        for(int i=0; i<m; i++) {
            if(inputArr[i][0].equals("1")) {
                stack.push(Integer.parseInt(inputArr[i][1]));
            } else if(inputArr[i][0].equals("2")) {
                stack.pop();
            } else {
                stack.top();
            }
        }
    }
}