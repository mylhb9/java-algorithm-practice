package level6;

import java.util.Scanner;

// 문제: 띄어쓰기를 모두 제거하는 프로그램
// 입력: 문서는 문자열임. 길이는 100000을 넘기지 않는다.
// 출력: 문자열의 띄어쓰기를 모두 제거한 결과를 출력한다.
public class SpoilAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        input = input.replace(" ", "");
        System.out.println(input);
    }
}
