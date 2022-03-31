package level6;

import java.util.Scanner;

// 문제: 연속된 부분 문자열을 압축하여 출력하는 프로그램을 작성
// AAABBBBBC->3A5BC
// 입력: 압축하고자 하는 문자열이 주어짐. 문자열의 길이는 1000보다 작다.
// 문자열에 구성된 알파벳은 대문자이다.
// 출력: 압축한 결과를 출력한다.
public class CompressionString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 처리:
        // 1. 배열로 입력을 받아서
        // 2. 같으면 숫자를 더하고, 다르다면 그동안 더했던 숫자를 앞에 붙이고 출력한다.
        // 3. 마지막 열인 경우 주의해서 다르다면 마지막 것도 함께 출력한다.

        char[] charArr = sc.nextLine().toCharArray();
        int count = 1;
        for(int i=1; i<charArr.length; i++) {
            if(charArr[i-1] == charArr[i] && i != charArr.length-1) {
                count++;
            } else if(charArr[i-1] != charArr[i] && i != charArr.length-1) {
                if(count != 1) {
                    System.out.print(count+""+charArr[i-1]);
                } else {
                    System.out.print(charArr[i-1]);
                }
                count = 1;
            } else if(i == charArr.length-1) {
                if(charArr[i-1] == charArr[i]) {
                    count++;
                    System.out.print(count+""+charArr[i-1]);
                } else {
                    if(count != 1) {
                        System.out.print(count+""+charArr[i-1]);
                    } else {
                        System.out.print(charArr[i-1]);
                    }
                    System.out.print(charArr[i]);
                }
            }
        }
    }
}
