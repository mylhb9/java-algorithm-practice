package level8;


// 문제: 임의의 자연수는 그보다 작은 자연수들의 합으로 표현될 수 있다.
// 자연수 n을 입력 받아 이를 n보다 작은 자연수들의 합으로 나타내는 방법을 모두 출력하는 프로그램을
// 재귀호출을 사용하여 작성하라

// 입력: 2 이상 20 이하의 자연수 n 이 주어진다.
// 출력: 모든 방법을 한 줄에 하나씩 출력한다.
// 하나의 식 안에는 큰 숫자가 앞으로 오도록하고, 전체적으로는 앞의 숫자가 큰 식이 먼저 출력되도록한다.
// 숫자와 더하기 사이에는 공백이 없다. 마지막 줄에는 나누어진 자연수의 개수를 출력한다.
import java.util.Scanner;

public class Division {
    int n;
    Integer[] notes;
    int count = 0;
    public void printDivision(int x, int sum) {
        if(sum >= n) {
            if(sum == n) {
                StringBuffer sb = new StringBuffer();
                for(int i=0; i<notes.length-1; i++) {
                    if(notes[i] == null) {
                        return;
                    }
                    if(notes[i+1] == null) {
                        sb.append(notes[i]);
                        break;
                    }
                    if(notes[i] >= notes[i+1]) {
                        sb.append(notes[i]+"+");
                    } else {
                        return;
                    }
                }
                System.out.println(sb);
                count++;
            }
        } else {
            for(int i=n-1; i>=1; i--) {
                notes[x] = i;
                sum+=notes[x];
                printDivision(x+1, sum);
                sum-=notes[x];
                notes[x] = null;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Division m = new Division();
        m.n = n;
        m.notes = new Integer[22];
        m.printDivision(0, 0);
        System.out.println(m.count);
    }
}
