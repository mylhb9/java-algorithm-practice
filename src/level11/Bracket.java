package level11;

// 문제: 괄호
// 괄호 문자열은 두 개의 기호 '(' 와 ')' 만으로 구성되어 있는 문자열임
// 바르게 구성된 문자열을 올바른 괄호 문자열 VPS라고 부름
// 입력으로 주어진 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 또는 NO로 나타내야함

// 입력: 괄호 문자열이 한 줄에 주어짐. 하나의 괄호 문자열의 길이는 2 이상 50 이하이다

// 출력: 괄호 문자열이 VPS 라면 "YES" 아니면 "NO" 를 한줄에 하나씩 차례대로 출력


import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArr = sc.nextLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        if(charArr[0] == ')') {
            System.out.println("NO");
            return;
        }
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
