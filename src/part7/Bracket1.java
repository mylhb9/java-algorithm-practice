package part7;

import java.util.Scanner;
import java.util.Stack;

public class Bracket1 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        char[] inputArr = sc.nextLine().toCharArray();
        for(int i=0; i<inputArr.length; i++) {
            if(inputArr[i] == '(') {
                stack.push('(');
            } else {
                if(!stack.empty()) {
                    stack.pop();
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if(stack.empty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
