package level6;

import java.util.Scanner;

// 문제: 문자열이 주어질 때, 앞으로 읽을 때와 뒤로 읽을 때의 결과가 같은 문자열인지 조사해라
// 입력: 문자열이 주어짐 (1 <= 문자열 길이 <= 1000)
// 출력: 팰린드롬이면 YES, 아니면 NO
public class PalindromicInvestigation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean check = false;
        char[] charArr = sc.nextLine().toCharArray();
        for(int i=0; i<charArr.length/2; i++) {
            if(charArr[i] != charArr[charArr.length-1-i]) {
                check = true;
            }
        }
        if(!check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
