package part7;

import java.util.Scanner;
import java.util.Stack;

public class Bracket2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArr = sc.nextLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<charArr.length; i++) {
            if(charArr[i] == '(') {
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
