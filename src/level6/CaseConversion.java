package level6;

import java.util.Scanner;

// 문제: 문자열이 주어지면, 대문자는 소문자로, 소문자는 대문자로 바꾸는 프로그램을 작성
// 알파벳이 아닌 문자는 그대로 유지한다.
// 입력: 문자열이 주어진다, (1<= 문자열 길이 <= 1000)
// 출력: 문자열 내의 대문자는 소문자로, 소문자는 대문자로 바꿔 결과를 출력한다.
public class CaseConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArr = sc.nextLine().toCharArray();
        for(int i=0; i<charArr.length; i++) {
            if(charArr[i] >= 65 && charArr[i] <= 90) {
                charArr[i] += 32;
            } else if(charArr[i] >= 97 && charArr[i] <= 122) {
                charArr[i] -= 32;
            }
        }
        for(int i=0; i<charArr.length; i++) {
            System.out.print(charArr[i]);
        }
    }
}