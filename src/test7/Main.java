package test7;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] inputArr = sc.nextLine().toCharArray();
        int length = inputArr.length;


        char[] charArr= new char[length];
        Stack<Character> charArrStack = new Stack<>();
        for(int i=0; i<length; i++) {
            charArr[i] = (char) ('a'+i);
        }
        for(int i=0; i<length; i++) {
            charArrStack.push(charArr[length-1-i]);
        }

        Stack<Character> stack = new Stack<>();
        int idx = 0;
        while(!charArrStack.empty() ) {


            if(!charArrStack.empty() && charArrStack.peek() < inputArr[idx]) {
                stack.push(charArrStack.pop());
                System.out.println("push");
            } else if(!charArrStack.empty() && charArrStack.peek() == inputArr[idx]) {
                stack.push(charArrStack.pop());
                System.out.println("push");
                char a = stack.pop();
                System.out.println("pop");
                idx++;
                while(!stack.empty() && stack.peek() < a) {
                    a = stack.pop();
                    System.out.println("pop");
                    idx++;

                }
            }
        }

        if(idx != length) {
            System.out.println("impossible");
        }

    }
    // bacd
    // dabc
    // abcd
}
