package part7;

import java.util.Scanner;
class Stack1 {
    Integer[] intArr = new Integer[101];
    int idx = 0;
    int size;
    void push(int x) {
        if(idx >= size) {
            System.out.println("Overflow");
        } else {
            idx++;
            intArr[idx] = x;
        }
    }

    void pop() {
        if(idx < 1) {
            System.out.println("Underflow");
        } else {
            intArr[idx] = null;
            idx--;
        }

    }

    void top() {
        if(idx < 1) {
            System.out.println("NULL");
        } else {
            System.out.println(intArr[idx]);
        }
    }
}


public class PrintStack2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);

        String[][] inputArr = new String[m][2];
        Stack1 stack = new Stack1();
        stack.size = n;


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
