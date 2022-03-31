package level6;

import java.util.Scanner;

// 문제: 덧셈, 뺄셈, 곱셈, 나눗셈을 할 수 있는 계산기 프로그램을 만들어라.
// 입력: 숫자 a가 입력됨, 둘째 줄에는 연산자가 입력됨, 마지막 줄에는 숫자 b가 입력됨
// 출력: a 와 b 를 주어진 연선자를 활용하여 계산 결과 출력
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int a = Integer.parseInt(sc.nextLine());
        String operator = sc.nextLine();
        int b = Integer.parseInt(sc.nextLine());

        // 처리: operator 를 받아서 해당하는 연산으로 분기해준다.
        // 출력
        if(operator.equals("+")) {
            System.out.println(a+b);
        } else if(operator.equals("-")) {
            System.out.println(a-b);
        } else if(operator.equals("/")) {
            System.out.println(a/b);
        } else if(operator.equals("*")) {
            System.out.println(a*b);
        }
    }
}
