package level7;

// 문제: 봉우리가 여러개인 산 모양을 출력한다.
// 산 모양은 그림과 같고 좌우 대칭이다.

import java.util.Scanner;

// 입력: 20보다 작은 자연수를 입력받는다.
// 출력: 예의 형식으로 출력한다.
public class Main {
    int n;
    Integer[] notes;
    public void printMountain(int x) {
        if(x==n) {

        } else {
            for(int i=1; i<=Math.pow(2,n)-1; i++) {
                if(i % 2 == 1) {
                    notes[i] = 1;
                } else {

                    notes[i] = i - 1;
                    if(notes[i] > n) {
                        notes[i] = notes[i] - n;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
    }
}
// 1 2 3 4
// 1 3 7 15
// 2^n -1
