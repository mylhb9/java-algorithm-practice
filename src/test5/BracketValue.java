package test5;

import java.util.*;

public class BracketValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArr = sc.nextLine().toCharArray();

        if(charArr.length % 2 == 1 || charArr[0] == ')' || charArr[0] == ']') {
            System.out.println(0);
            return;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<charArr.length; i++) {
            if(charArr[i] == '(' || charArr[i] == '[') {
                if(charArr[i] == '(') {
                    stack.push(-1);
                } else {
                    stack.push(-2);
                }
            } else {
                if(charArr[i] == ')') {
                    if(!stack.empty()) {
                        if(stack.peek() == -1) {
                            stack.pop();
                            stack.push(2);
                        } else if(stack.peek() == -2) {
                            System.out.println(0);
                            return;
                        } else {
                            int temp = stack.pop();
                            if(stack.peek() == -1) {
                                stack.pop();
                                stack.push(2*temp);
                            } else if(stack.peek() == -2) {
                                System.out.println(0);
                                return;
                            }
                        }
                    }
                } else {
                    if(!stack.empty()) {
                        if(stack.peek() == -2) {
                            stack.pop();
                            stack.push(3);
                        } else if(stack.peek() == -1) {
                            System.out.println(0);
                            return;
                        } else {
                            int temp = stack.pop();
                            if(stack.peek() == -2) {
                                stack.pop();
                                stack.push(3*temp);
                            } else if(stack.peek() == -1) {
                                System.out.println(0);
                                return;
                            }
                        }
                    }
                }

                if(!stack.empty() && stack.peek() != -1 && stack.peek() != -2) {
                    int temp = stack.pop();
                    if(!stack.empty() && stack.peek() != -1 && stack.peek() != -2) {
                        stack.push(stack.pop() + temp);
                    } else {
                        stack.push(temp);
                    }
                }
            }
        }

        if(stack.size()==1) {
            System.out.println(stack.peek());
        } else {
            System.out.println(0);
        }
    }
}
