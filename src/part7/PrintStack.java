package part7;


import java.util.Scanner;

class Stack {
    int length = 0;
    int capacity;
    Integer[] intArr = new Integer[100];

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    void push(int x) {
        if(length >= capacity) {
            System.out.println("Overflow");
        } else {
            intArr[length] = x;
            length++;
        }
    }
    void pop() {
        if(length <= 0) {
            System.out.println("Underflow");
        } else {
            intArr[length-1] = 0;
            length--;
        }
    }
    void top() {
        if(length <= 0) {
            System.out.println("NULL");
        } else {
            System.out.println(intArr[length-1]);
        }
    }
}



public class PrintStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);


        Stack stack = new Stack(n);

        String[][] inputArr = new String[m][2];
        for(int i=0; i<m; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }
        for(int i=0; i<m; i++) {
            if(inputArr[i][0].equals("1")) {
                stack.push(Integer.parseInt(inputArr[i][1]));
            } else if(inputArr[i][0].equals("2")) {
                stack.pop();
            } else if(inputArr[i][0].equals("3")) {
                stack.top();
            }
        }
    }
}
