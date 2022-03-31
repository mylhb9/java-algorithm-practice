package level6;


// 문제: 문자열 A B 가 주어질 때, B가 A 에 포함되어 있는지를 조사하는 프로그램 작성.
// A B 는 알파벳으로만 이루어져 있으며, 공백은 포함되지 않음.

import java.util.Scanner;

// 입력: 첫 째줄 A, 둘 째줄 B 가 주어짐. 길이는 1000을 넘지 않음, 모두 소문자로만 구성
// 출력: 포함되면 YES, 아니면 NO 출력
public class InvestigateStringInclusion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();
        String B = sc.nextLine();

        if(A.contains(B)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}