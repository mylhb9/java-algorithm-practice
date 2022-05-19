package additiontype;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        // 8개 중에서 4개를 선택할 것

        // 1     2      3
        // 3     7      4
        // 6     13     9
        // 14           11

        // 방법1: 월급을 많이 주는 순서대로 더하고, 나중에 같은게 있다면 추가 월급을 받는 것
        // 방법2: 같은 업종의 개수가 제일 많은 것을 고르고, 추가 월급을 받은 뒤, 남은 업종 중 가장 큰 월급을 가진 것을 더하는 것
        // 방법2로 간다면 다시 남은 업종 중 방법1과 방법2로 나뉨.

        sc.close();
    }
}
