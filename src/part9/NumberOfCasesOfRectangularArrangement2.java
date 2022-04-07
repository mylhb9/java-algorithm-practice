package part9;


// 문제: 직사각형배치의 경우의수
// 2 X N 직사각형 모양의 칸이 있다. 이를 2 X 1 모양의 타일로 가득 채우려고한다.
// 가능한 경우의 수를 출력하는 프로그램을 작성해라

import java.util.Scanner;

public class NumberOfCasesOfRectangularArrangement2 {
    Integer[] notes;
    public int getSquare(int x) {
        if(x==1) {
            return 1;
        } else if(x==2) {
            return 2;
        } else {
            if(notes[x] != null) {
                return notes[x];
            }
            notes[x] = (getSquare(x-2) % 1000007 + getSquare(x-1) % 1000007) % 1000007;
            return notes[x];
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        NumberOfCasesOfRectangularArrangement2 m = new NumberOfCasesOfRectangularArrangement2();
        m.notes = new Integer[N+1];
        System.out.println(m.getSquare(N));

    }
}
