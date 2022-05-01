package level11;

// 문제: 괄호의값
// '()' : 값은 2
// '[]' : 값은 3
// '(X)' : 2 * X 값
// '[X]' : 3 * X 값
// XY : X + Y 값
// 괄호열을 읽고 그 괄호 값을 위에서 정의한대로 계산하여 출력

// 입력: 첫쨰 줄에 괄호열을 나타내는 문자열이 주어짐

// 출력: 괄호열의 값을 나타내는 정수를 출력, 입력이 올바르지 못한 괄호열이면 0을 반드시 출력해야함

import java.util.Scanner;
import java.util.Stack;

public class BracketValue {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);
        char[] charArr = sc.nextLine().toCharArray();

//        if(charArr[0] == ')' || charArr[0] == ']') {
//            System.out.println(0);
//            return;
//        }
        if(charArr.length % 2 != 0) {
            System.out.println(0);
            return;
        }

        for(int i=0; i<charArr.length; i++) {
            // 괄호대가리 부분
            if(charArr[i] == '(' || charArr[i] == '[') {
                if(charArr[i] == '(') {
                    stack.push(-1);
                } else {
                    stack.push(-2);
                }
            } else {
            // 괄호꼬리 부분

                if(charArr[i] == ')') {
                    if(!stack.empty()) {
                        if(stack.peek() == -1) {
                            stack.pop();
                            stack.push(2);
                        } else if(stack.peek() == -2) {
                            System.out.println(0);
                            return;
                        } else {
                            int pivot = stack.pop();
                            if(!stack.empty()) {
                                if(stack.pop() == -2) {
                                    System.out.println(0);
                                    return;
                                }
                                } else {
                                System.out.println(0);
                                return;
                            }
                            stack.push(pivot * 2);
                        }
                    }
                } else {
                    if(!stack.empty()) {
                        if(stack.peek() == -1) {
                            System.out.println(0);
                            return;
                        } else if(stack.peek() == -2) {
                            stack.pop();
                            stack.push(3);
                        } else {
                            int pivot = stack.pop();
                            if(!stack.empty()) {
                                if(stack.pop() == -1) {
                                    System.out.println(0);
                                    return;
                                }
                            } else {
                                System.out.println(0);
                                return;
                            }
                            stack.push(pivot * 3);
                        }
                    }
                }
                if(!stack.empty() && !(stack.peek() == -1 || stack.peek() == -2)) {
                    int temp = stack.pop();
                    if(!stack.empty() && !(stack.peek() == -1 || stack.peek() == -2)) {
                        temp = temp + stack.pop();
                        stack.push(temp);
                    } else {
                        stack.push(temp);
                    }
                }
            }
        }
        if(stack.size() == 1) {
            if(stack.get(0) > 0) {
                System.out.println(stack.get(0));
            } else {
                System.out.println(0);
            }
        } else {
            System.out.println(0);
        }

    }
}
