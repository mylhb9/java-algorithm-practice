package level6;

// 문제: 문자열을 뒤집어서 출력하는 프로그램을 만들어라
// 입력: 문자열이 주어짐 (1<= 문자열의 길이 <= 1000)
// 출력: 문자열을 뒤집은 결과를 출력한다
import java.util.Scanner;

public class FlipString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArr = sc.nextLine().toCharArray();
        // 처리: 입력받은 문자 배열을 거꾸로 출력한다.
        for(int i=charArr.length-1; i>=0; i--) {
            System.out.print(charArr[i]);
        }
    }
}
