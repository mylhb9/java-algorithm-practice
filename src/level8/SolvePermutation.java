package level8;

import java.util.Arrays;
import java.util.Scanner;

// 문제: 서로 다른 n개의 원소들 중에서 r개만을 뽑아 일렬로 나열하는 것을 순열
// n 개의 소문자 중에서 r 개만을 뽑아 나열하는 모든 경우를 출력하는 프로그램을 작성
public class SolvePermutation {
    int r;
    int n;
    char[] notes;
    boolean[] checks;
    public void getResult(int x) {
        if(x >= r) {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<notes.length; i++) {
                if(notes[i] != 0) {
                    sb.append(notes[i]);
                }
            }
            System.out.println(sb);
        } else {
            for(int i=0; i<n; i++) {
                if(!checks[i]) {
                    char pivot = (char) ('a'+i);
                    notes[x] = pivot;
                    checks[i] = true;
                    getResult(x+1);
                    notes[x] = 0;
                    checks[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int r = Integer.parseInt(strArr[1]);

        SolvePermutation m = new SolvePermutation();
        m.n = n;
        m.r = r;
        m.checks = new boolean[50];
        Arrays.fill(m.checks, false);
        m.notes = new char[50];
        m.getResult(0);

    }
}
