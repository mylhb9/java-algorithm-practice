package level8;


// 문제: 두 정수 n, k 를 입력받아 k개의 1을 가진 n자리 이진 패턴을 출력하는 프로그램을 작성하세요.
// 입력: 두 정수 n, k 가 입력으로 주어진다.
// 출력: 결과를 내림차순으로 출력
import java.util.Arrays;
import java.util.Scanner;

public class ToBin {
    int n;
    int k;
    Integer[] notes;
    Integer[] checks;
    public void getResult(int x) {
        if(x >= n) {
            if(checks[1] == k) {
                StringBuffer sb = new StringBuffer();
                for(int i=0; i<notes.length; i++) {
                    if(notes[i] != null) {
                        sb.append(notes[i]);
                    } else {
                        break;
                    }
                }
                System.out.println(sb);
            }
        } else {
            for(int i=1; i>=0; i--) {
                notes[x] = i;
                checks[i]++;
                getResult(x + 1);
                checks[i]--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int k = Integer.parseInt(strArr[1]);

        ToBin m = new ToBin();
        m.n = n;
        m.k = k;
        m.notes = new Integer[31];
        m.checks = new Integer[2];
        Arrays.fill(m.checks, 0);
        m.getResult(0);
    }
}
