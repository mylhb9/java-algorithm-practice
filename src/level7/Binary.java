package level7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 문제: 숫자를 입력 받아 이진수를 출력하는 프로그램을 작성해라
// 입력: 숫자의 크기는 1000보다 작거나 같다.
// 출력: 숫자를 이진수로 바꾸어 출력한다.
public class Binary {
    List<Integer> list = new ArrayList<>();
    public void getBinary(int x) {
        if(x == 0) {
            for(int i=list.size()-1; i>=0; i--) {
                System.out.print(list.get(i));
            }
        } else {
            list.add(x%2);
            getBinary(x/2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Binary m = new Binary();
        m.getBinary(N);
    }
}
