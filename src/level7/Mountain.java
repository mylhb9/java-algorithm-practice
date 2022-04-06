package level7;

// 문제: 봉우리가 여러개인 산 모양을 출력한다.
// 산 모양은 그림과 같고 좌우 대칭이다.

import java.util.Scanner;

// 입력: 20보다 작은 자연수를 입력받는다.
// 출력: 예의 형식으로 출력한다.
public class Mountain {
    int n;
    public String printMountain(int x) {
        if(x==1) {
            return "1";
        } else {
            return printMountain(x-1) + x + printMountain(x-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Mountain m = new Mountain();
        m.n = N;
        System.out.println(m.printMountain(N));
    }
}
// 1 -> 1 f(1)
// 2 -> 1 2 1  f(2)
// 3 -> 1 2 1 3 1 2 1 f(3)
// f(n) = f(n-1) + n + f(n-1)
