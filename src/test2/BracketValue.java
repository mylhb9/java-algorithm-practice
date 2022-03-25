package test2;

import java.util.Scanner;
import java.util.Stack;

public class BracketValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        char[] inputArr = sc.nextLine().toCharArray();
        for(int i=0; i<inputArr.length; i++) {
            if(inputArr[i] == '(' || inputArr[i] == '[') {
                if(inputArr[i] == '(') {
                    stack.push(-1);
                } else {
                    stack.push(-2);
                }
            } else {
                if(stack.empty()) {
                    System.out.println(0);
                    return;
                }
                if(inputArr[i] == ')') {
                    if(stack.peek() == -1) {
                        stack.pop();
                        stack.push(2);
                    } else if(stack.peek() == -2) {
                        System.out.println(0);
                        return;
                    } else {
                        int pivot = stack.pop();
                        if(!stack.empty()) {
                            if(stack.peek() == -1) {
                                stack.pop();
                                stack.push(pivot * 2);
                            } else if(stack.peek() == -2) {
                                System.out.println(0);
                                return;
                            }
                        } else {
                            System.out.println(0);
                            return;
                        }
                    }
                    if(stack.size() >= 2 && stack.peek() != -1 && stack.peek() != -2) {
                        int pivot = stack.pop();
                        if(stack.peek() !=-1 && stack.peek() != -2) {
                            stack.push(pivot + stack.pop());
                        } else {
                            stack.push(pivot);
                        }
                    }
                } else {
                    if(stack.peek() == -1) {
                        System.out.println(0);
                        return;
                    } else if(stack.peek() == -2) {
                        stack.pop();
                        stack.push(3);
                    } else {
                        int pivot = stack.pop();
                        if(!stack.empty()) {
                            if(stack.peek() == -2) {
                                stack.pop();
                                stack.push(pivot * 3);
                            } else if(stack.peek() == -1) {
                                System.out.println(0);
                                return;
                            }
                        } else {
                            System.out.println(0);
                            return;
                        }
                    }
                    if(stack.size() >= 2 && stack.peek() != -1 && stack.peek() != -2) {
                        int pivot = stack.pop();
                        if(stack.peek() !=-1 && stack.peek() != -2) {
                            stack.push(pivot + stack.pop());
                        } else {
                            stack.push(pivot);
                        }
                    }
                }
            }
        }
        if(stack.size() == 1 && stack.get(0) > 0) {
            System.out.println(stack.get(0));
        } else {
            System.out.println(0);
        }
    }
}
