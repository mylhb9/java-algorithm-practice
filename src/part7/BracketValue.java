package part7;

import java.util.Scanner;
import java.util.Stack;

public class BracketValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split("");

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<strArr.length; i++) {
            if(strArr[i].equals("(") || strArr[i].equals("[")) {
                if(strArr[i].equals("(")) {
                    stack.push(-1);
                } else {
                    stack.push(-2);
                }
            } else {
                if(stack.empty()) {
                    System.out.println(0);
                    return;
                }
                if(strArr[i].equals(")")) {
                    if(stack.peek() == -1) {
                        stack.pop();
                        stack.push(2);
                    } else if(stack.peek() == -2) {
                        System.out.println(0);
                        return;
                    } else {
                        int pivot = stack.pop();
                        if(stack.peek() == -1) {
                            stack.pop();
                            stack.push( pivot * 2);
                        } else if(stack.peek() == -2) {
                            System.out.println(0);
                            return;
                        }
                    }
                    if(stack.size() >= 2) {
                        if(stack.peek() != -1 && stack.peek() != -2) {
                            int pivot = stack.pop();
                            if(stack.peek() != -1 && stack.peek() != -2) {
                                stack.push(stack.pop() + pivot);
                            } else {
                                stack.push(pivot);
                            }
                        }
                    }
                } else {
                    if(stack.peek() == -2) {
                        stack.pop();
                        stack.push(3);
                    } else if(stack.peek() == -1) {
                        System.out.println(0);
                        return;
                    } else {
                        int pivot = stack.pop();
                        if(stack.peek() == -2) {
                            stack.pop();
                            stack.push( pivot * 3);
                        } else if(stack.peek() == -1) {
                            System.out.println(0);
                            return;
                        }
                    }
                    if(stack.size() >= 2) {
                        if(stack.peek() != -1 && stack.peek() != -2) {
                            int pivot = stack.pop();
                            if(stack.peek() != -1 && stack.peek() != -2) {
                                stack.push(stack.pop() + pivot);
                            } else {
                                stack.push(pivot);
                            }
                        }
                    }
                }
            }

        }
        if(stack.size() == 1 && stack.get(0) > 0) {
            System.out.println(stack.pop());
        } else {
            System.out.println(0);
        }
    }
}