package part9;

import java.util.Scanner;

// 문제: 숫자 1, 2, 3 을 이용하여 숫자 N을 만드는 경우의 수를 출력하는 프로그램을 작성
// 경우의 수를 1000007로 나눈 나머지를 출력한다.
// N은 1이상 100000이하의 범위를 갖는다
public class MakeNum1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        Integer[] notes = new Integer[100001];
        notes[1] = 1;
        notes[2] = 2;
        notes[3] = 4;
        for(int i=1; i<=N-3; i++) {
            notes[i+3] = (notes[i] + notes[i+1] + notes[i+2]) % 1000007;
        }
        System.out.println(notes[N]);
    }
}



// 1: 1
// 2: 1+1  2
// 3: 1+1+1  2+1  1+2  3
// 4: 1+1+1+1  2+1+1  1+2+1  3+1  1+1+2  2+2  1+3
// 5: 1+1+1+1+1  2+1+1+1  1+2+1+1  3+1+1  1+1+2+1  2+2+1  1+3+1  1+1+1+2  2+1+2  1+2+2  3+2  1+1+3  2+3
