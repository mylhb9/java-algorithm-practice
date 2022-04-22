package part11;

// 문제: 이상한 계산기는 두 가지 버튼과 숫자를 출력하는 화면으로 구성돼 있다.
//

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WeirdCalculator1 {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] check = new boolean[100000];
    Integer[] countArr = new Integer[100000];
    public void BFS() {
        queue.offer(1);
        check[1] = true;
        countArr[1] = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            if(current*2 < 100000 && !check[current*2]) {
                queue.offer(current*2);
                check[current*2] = true;
                countArr[current*2] = countArr[current] + 1;
            }

            if(current/3 >= 1 && !check[current/3]) {
                queue.offer(current/3);
                check[current/3] = true;
                countArr[current/3] = countArr[current] + 1;
            }
        }




    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        WeirdCalculator1 m = new WeirdCalculator1();
        Arrays.fill(m.countArr, 0);
        m.BFS();
        System.out.println(m.countArr[N]);
    }
}
