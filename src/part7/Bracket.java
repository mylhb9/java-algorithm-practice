package part7;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inputArr = sc.nextLine().split("");
        Stack<String> stack = new Stack<>();

        boolean check = false;
        for(int i=0; i<inputArr.length; i++) {
            if(inputArr[i].equals("(")) {
                stack.push("(");
            } else {
                if(!stack.empty()) {
                    stack.pop();
                } else {
                    check = true;
                    break;
                }
            }
        }
        if(!stack.empty()) {
            System.out.println("NO");
            return;
        }
        if(check) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
